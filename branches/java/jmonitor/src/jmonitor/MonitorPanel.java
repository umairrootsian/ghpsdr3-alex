/*
 * MonitorPanel.java
 * Created by John Melton G0ORX
 * Created on 01-Feb-2010, 08:34:50
 */

/*
 * This code has been and reviewed modified.
 * John Tucker, N8MDP
 */

/*
 * Revsion History
 * 1/20/13: Updated the "public void updateSamples()" function to now include:
 *          1. offset - adjustment factor to relocate the Filter block based
 *                      on the dspserver offset value.
 *          2. localOscOffset - This is the actual dspserver offset value in Hz
 * 
 * 
 */

package jmonitor;

public class MonitorPanel  extends javax.swing.JPanel implements MonitorUpdateListener {

    /** Creates new form MonitorPanel */
    public MonitorPanel() {
        initComponents();
    }

    public void setClient(Client client) {
        controlPanel.setClient(client);
        spectrumPanel.setClient(client);
        waterfallPanel.setClient(client);
    }

    public void updateSamples(float[] samples, int filterLow, int filterHigh, int sampleRate, int offset, int localOscOffset) {
        spectrumPanel.updateMonitor(samples,filterLow,filterHigh,sampleRate,offset,localOscOffset);
        waterfallPanel.updateWaterfall(samples,filterLow,filterHigh,sampleRate);
        spectrumPanel.drawSpectrum(offset,localOscOffset);
        controlPanel.updateVFO();
    }

    public void updateStatus() {
        spectrumPanel.updateStatus();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spectrumPanel = new jmonitor.SpectrumPanel();
        waterfallPanel = new jmonitor.WaterfallPanel();
        controlPanel = new jmonitor.ControlPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spectrumPanel.setAlignmentX(0.0F);
        spectrumPanel.setAlignmentY(0.0F);
        spectrumPanel.setMaximumSize(new java.awt.Dimension(480, 100));
        spectrumPanel.setMinimumSize(new java.awt.Dimension(480, 100));

        javax.swing.GroupLayout spectrumPanelLayout = new javax.swing.GroupLayout(spectrumPanel);
        spectrumPanel.setLayout(spectrumPanelLayout);
        spectrumPanelLayout.setHorizontalGroup(
            spectrumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );
        spectrumPanelLayout.setVerticalGroup(
            spectrumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(spectrumPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 482, 100));

        waterfallPanel.setAlignmentX(0.0F);
        waterfallPanel.setAlignmentY(0.0F);
        waterfallPanel.setMaximumSize(new java.awt.Dimension(480, 100));
        waterfallPanel.setMinimumSize(new java.awt.Dimension(480, 100));

        javax.swing.GroupLayout waterfallPanelLayout = new javax.swing.GroupLayout(waterfallPanel);
        waterfallPanel.setLayout(waterfallPanelLayout);
        waterfallPanelLayout.setHorizontalGroup(
            waterfallPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );
        waterfallPanelLayout.setVerticalGroup(
            waterfallPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(waterfallPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 482, 100));

        controlPanel.setBackground(new java.awt.Color(0, 0, 0));
        add(controlPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jmonitor.ControlPanel controlPanel;
    private jmonitor.SpectrumPanel spectrumPanel;
    private jmonitor.WaterfallPanel waterfallPanel;
    // End of variables declaration//GEN-END:variables

}
