import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.util.ArrayList;
import java.util.List;

public class CinemaReservationSystem {
    private JFrame frame;
    private JComboBox<Movie> movieComboBox;
    private JComboBox<CinemaHall> hallComboBox;
    private DatePicker datePicker;
    private JButton reserveButton;
    private MovieList movieList;
    private List<CinemaHall> hallList;

    public CinemaReservationSystem() {
        movieList = new MovieList();
        hallList = new ArrayList<>();
        addCinemaHalls(); // Dodaj przykładowe sale kinowe
    }

    private void addCinemaHalls() {
        CinemaHall hall1 = new CinemaHall("Sala 1", 10);
        CinemaHall hall2 = new CinemaHall("Sala 2", 80);
        CinemaHall hall3 = new CinemaHall("Sala 3", 120);

        hallList.add(hall1);
        hallList.add(hall2);
        hallList.add(hall3);
    }

    public void createAndShowGUI() {
        frame = new JFrame("System Rezerwacji Kinowych");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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

        JPanel datePickerPanel = new JPanel(new FlowLayout());
        datePickerPanel.add(datePicker);

        reserveButton = new JButton("Zarezerwuj");
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reserveButtonClicked();
            }
        });

        mainPanel.add(movieLabel);
        mainPanel.add(movieComboBox);
        mainPanel.add(hallLabel);
        mainPanel.add(hallComboBox);
        mainPanel.add(dateLabel);
        mainPanel.add(datePickerPanel);
        mainPanel.add(new JLabel());
        mainPanel.add(reserveButton);

        frame.getContentPane().add(mainPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void reserveButtonClicked() {
        Movie selectedMovie = (Movie) movieComboBox.getSelectedItem();
        CinemaHall selectedHall = (CinemaHall) hallComboBox.getSelectedItem();
        String date = datePicker.getDateStringOrEmptyString();

        if (selectedMovie == null || selectedHall == null || date.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Proszę wybrać film, salę i datę.");
            return;
        }

        Reservation reservation = new Reservation(selectedMovie, selectedHall, date);

        String message = "Zarezerwowano film: " + selectedMovie.getTitle() + "\n"
                + "Sala kinowa: " + selectedHall.getName() + "\n"
                + "Data: " + date;

        JOptionPane.showMessageDialog(frame, message);

        movieComboBox.setSelectedIndex(0);
        hallComboBox.setSelectedIndex(0);
        datePicker.clear();
    }

    public static void main(String[] args) {
        CinemaReservationSystem system = new CinemaReservationSystem();
        system.createAndShowGUI();
    }

    public void addMovie(Movie movie1) {
    }

    public void addCinemaHall(CinemaHall hall1) {
    }
}
