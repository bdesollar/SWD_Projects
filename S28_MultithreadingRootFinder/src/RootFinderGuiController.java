import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * the GUI controller for root finder
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class RootFinderGuiController {

    /**
     * number of sets label reference that can be used to access the number of sets label
     */
    @FXML
    private Label numberOfSetsLabel;

    /**
     * number of sets text field reference that can be used to access the number of sets text field
     */
    @FXML
    private TextField numberOfSetsTextField;

    /**
     * lineChart reference that can be used to access the lineChart
     */
    @FXML
    private LineChart<Number, Number> lineChart;

    /**
     * output data text area reference that can be used to access the output data text area
     */
    @FXML
    private TextArea outputDataTextArea;

    /**
     * number of sets of roots the user asks to solve
     */
    private int numberOfSetsToCalculate;

    /**
     * action performed when the button is pressed to calculate roots, which calls the master to create slave threads to calculate the roots
     * @param event Action event object used to access info about the event
     * @throws InterruptedException exception occurs if the thread has been interrupted
     */
    @FXML
    public void buttonPressed(ActionEvent event) throws InterruptedException {
        Master master = new Master();
        this.numberOfSetsToCalculate = Integer.parseInt(numberOfSetsTextField.getText());
        master.setNumberOfSetsToCalculate(this.numberOfSetsToCalculate);
        master.runMaster();
        while(!master.getSharedLocationMaster().getFinishedState())
        {
            wait();
        }
        if(this.numberOfSetsToCalculate <= 30)
        {
            for (int j = 0; j < master.getArrayList().size(); j++) {
                outputDataTextArea.appendText("Set " + (j + 1) + " calculation: " + master.getArrayList().get(j)[0] + " " + master.getArrayList().get(j)[1] + "\n");
                System.out.println("Set " + (j + 1) + " calculation: " + master.getArrayList().get(j)[0] + " " + master.getArrayList().get(j)[1]);
            }
        }
        else
        {
            XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
            series1.setName("Performance of Thread Calculations");
            for(Integer key : master.getSharedLocationMaster().getNumberOfCalculationsEachThreadDid().keySet())
            {
                series1.getData().add(new XYChart.Data<>(master.getSharedLocationMaster().getNumberOfCalculationsEachThreadDid().get(key), master.getSharedLocationMaster().getTimeTakenToCalculateByEachThread().get(key)));
                System.out.println("Slave " + key + " finished " + master.getSharedLocationMaster().getNumberOfCalculationsEachThreadDid().get(key) + " calculations in " + master.getSharedLocationMaster().getTimeTakenToCalculateByEachThread().get(key) + " seconds");
                outputDataTextArea.appendText("Slave " + key + " finished " + master.getSharedLocationMaster().getNumberOfCalculationsEachThreadDid().get(key) + " calculations in " + master.getSharedLocationMaster().getTimeTakenToCalculateByEachThread().get(key) + " seconds\n");
            }
            lineChart.getData().add(series1);

            //Setting the data to Line chart
            lineChart.getData().add(series1);
            lineChart.setVisible(true);
        }
    }

    /**
     * called by FXMLLoader to initialize the controller
     */
    // called by FXMLLoader to initialize the controller
    public void initialize() {
    }
}
