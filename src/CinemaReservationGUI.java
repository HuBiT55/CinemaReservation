import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.util.ArrayList;
import java.util.List;

public class CinemaReservationGUI {
    private JFrame frame;
    private JComboBox<Movie> movieComboBox;
    private JComboBox<CinemaHall> hallComboBox;
    private DatePicker datePicker;
    private JButton reserveButton;
    private MovieList movieList;
    private List<CinemaHall> hallList;
    private JPanel seatPanel;
    private JButton[][] seatButtons;

    private CinemaHall selectedHall;
    private int selectedRow = -1;
    private int selectedSeat = -1;

    public CinemaReservationGUI() {
        movieList = new MovieList();
        hallList = new ArrayList<>();
        addCinemaHalls(); // Dodaj przykładowe sale kinowe
    }

    private void addCinemaHalls() {
        CinemaHall hall1 = new CinemaHall("Sala 1", 100, 10, 10);
        CinemaHall hall2 = new CinemaHall("Sala 2", 80, 8, 12);
        CinemaHall hall3 = new CinemaHall("Sala 3", 120, 12, 15);

        hallList.add(hall1);
        hallList.add(hall2);
        hallList.add(hall3);
    }

    public void createAndShowGUI() {
        frame = new JFrame("System Rezerwacji Kinowych");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel movieLabel = new JLabel("Wybierz film:");
        movieComboBox = new JComboBox<>();

        for (Movie movie : movieList.getMovies()) {
            movieComboBox.addItem(movie);
        }

        JLabel hallLabel = new JLabel("Wybierz salę kinową:");
        hallComboBox = new JComboBox<>();

        for (CinemaHall hall : hallList) {
            hallComboBox.addItem(hall);
        }

        JLabel dateLabel = new JLabel("Wybierz datę:");
        DatePickerSettings dateSettings = new DatePickerSettings();
        datePicker = new DatePicker(dateSettings);

        JLabel seatLabel = new JLabel("Wybierz miejsce:");

        formPanel.add(movieLabel);
        formPanel.add(movieComboBox);
        formPanel.add(hallLabel);
        formPanel.add(hallComboBox);
        formPanel.add(dateLabel);
        formPanel.add(datePicker);
        formPanel.add(seatLabel);
        formPanel.add(createSeatSelectionPanel());
        formPanel.add(new JLabel());

        JPanel buttonPanel = new JPanel();
        reserveButton = new JButton("Zarezerwuj");
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reserveButtonClicked();
            }
        });
        buttonPanel.add(reserveButton);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createSeatSelectionPanel() {
        JPanel seatSelectionPanel = new JPanel(new BorderLayout());
        seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(10, 10, 5, 5));
        seatButtons = new JButton[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                final int row = i;
                final int seat = j;
                JButton seatButton = new JButton("Rząd " + (i + 1) + ", Miejsce " + (j + 1));
                seatButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        seatButtonClicked(seatButton, row, seat);
                    }
                });
                seatPanel.add(seatButton);
                seatButtons[i][j] = seatButton;
            }
        }

        seatSelectionPanel.add(seatPanel, BorderLayout.CENTER);
        return seatSelectionPanel;
    }

    private void seatButtonClicked(JButton seatButton, int row, int seat) {
        if (seatButton.getBackground() == Color.GREEN) {
            seatButton.setBackground(null);
            selectedRow = -1;
            selectedSeat = -1;
        } else {
            resetSeatSelection();
            seatButton.setBackground(Color.GREEN);
            selectedRow = row + 1;
            selectedSeat = seat + 1;
        }
    }

    private void resetSeatSelection() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton seatButton = seatButtons[i][j];
                seatButton.setBackground(null);
            }
        }
    }

    private void reserveButtonClicked() {
        Movie selectedMovie = (Movie) movieComboBox.getSelectedItem();
        CinemaHall selectedHall = (CinemaHall) hallComboBox.getSelectedItem();
        String date = datePicker.getDateStringOrEmptyString();

        if (selectedMovie == null || selectedHall == null || date.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Proszę poprawnie uzupełnić wszystkie pola.");
            return;
        }

        if (selectedRow == -1 || selectedSeat == -1) {
            JOptionPane.showMessageDialog(frame, "Proszę wybrać miejsce kinowe.");
            return;
        }

        Reservation reservation = new Reservation(selectedMovie, selectedHall, date, selectedRow, selectedSeat);

        String message = "Zarezerwowano film: " + selectedMovie.getTitle() + "\n"
                + "Sala kinowa: " + selectedHall.getName() + "\n"
                + "Data: " + date + "\n"
                + "Miejsce: Rząd " + selectedRow + ", Miejsce " + selectedSeat;

        JOptionPane.showMessageDialog(frame, message);

        movieComboBox.setSelectedIndex(0);
        hallComboBox.setSelectedIndex(0);
        datePicker.clear();

        resetSeatSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CinemaReservationGUI gui = new CinemaReservationGUI();
                gui.createAndShowGUI();
            }
        });
    }
}
