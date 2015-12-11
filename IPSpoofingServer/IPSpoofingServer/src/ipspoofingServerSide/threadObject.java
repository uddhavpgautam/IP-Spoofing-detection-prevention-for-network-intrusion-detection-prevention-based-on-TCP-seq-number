package ipspoofingServerSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.table.DefaultTableModel;

class threadObject extends Thread {

    private final DefaultTableModel model;
    private final int timeout;
    private final String subnet;
    private final int range_start, range_end;

    public threadObject(DefaultTableModel model, String subnet, int range_start, int range_end, int timeout) {
        this.model = model;
        this.timeout = timeout;
        this.subnet = subnet;
        this.range_start = range_start;
        this.range_end = range_end;
    }

    @Override
    public void run() {
        for (int i = range_start; i < range_end; i++) {
            String host;
            host = subnet + "." + i;
            Process process;

            Runtime runTime = Runtime.getRuntime();
            try {
                process = runTime.exec("ping " + host);
//                if  ping then add into table
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                br.readLine();
                br.readLine();
                String output = br.readLine();
                if ((!output.contains(" Destination host unreachable.")) && (!output.contains("Request timed out."))) {
                    model.addRow(new Object[]{host});
                }
            } catch (IOException ex) {
            }
        }
    }
}
