/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.clothocad.tool.sequencechecker;

import java.io.File;
//import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
//import javax.swing.text.html.StyleSheet;

import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.openide.util.ImageUtilities;
import org.netbeans.api.settings.ConvertAsProperties;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.net.URL;
import java.net.HttpURLConnection;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import org.clothocore.api.data.Format;
import org.clothocore.api.data.Plasmid;
import org.clothocore.widget.fabdash.InventoryTopComponent;

import org.openide.util.Exceptions;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//org.clothocad.tool.sequencechecker//SeqChecker//EN", autostore = false)
public final class SeqCheckerTopComponent extends TopComponent {

    /** path to the icon used by the component and its open action */
    protected static final String ICON_PATH = "org/clothocad/tool/sequencechecker/SeqChecker.png";
    protected static final String PREFERRED_ID = "SeqCheckerTopComponent";
    protected static SeqCheckerTopComponent instance;
    protected SeqCheckController _controller;
    protected ArrayList<Construct> _constructs;
    protected JEditorPane _htmlPane;
    protected JScrollPane _scrollPane4;

    public SeqCheckerTopComponent() {
        initComponents();
        addHTMLPane();
        setName(NbBundle.getMessage(SeqCheckerTopComponent.class, "CTL_SeqCheckerTopComponent"));
        setToolTipText(NbBundle.getMessage(SeqCheckerTopComponent.class, "HINT_SeqCheckerTopComponent"));
        setIcon(ImageUtilities.loadImage(ICON_PATH, true));

        _constructs = new ArrayList<Construct>();
        _controller = new SeqCheckController();
    }

    protected String[][] generateConstructsArray() {
        Construct construct;
        int rows = _constructs.size();
        String[][] constructsArray = new String[rows][2];

        for (int i = 0; i < rows; ++i) {
            construct = _constructs.get(i);
            constructsArray[i][0] = construct.getIdentifier();
            constructsArray[i][1] = construct.getStatus();
        }

        return constructsArray;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _mainPanel = new javax.swing.JPanel();
        _mainToolBar = new javax.swing.JToolBar();
        _selectButton = new javax.swing.JButton();
        summaryButton = new javax.swing.JButton();
        _mainSplitPane = new javax.swing.JSplitPane();
        _splitPane2 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        _constructsTable = new javax.swing.JTable();
        _splitPane3 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        _clonesTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        _primersTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        _mainPanel.setRequestFocusEnabled(false);
        _mainPanel.setSize(new java.awt.Dimension(800, 600));

        _mainToolBar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        _mainToolBar.setFloatable(false);
        _mainToolBar.setRollover(true);

        org.openide.awt.Mnemonics.setLocalizedText(_selectButton, org.openide.util.NbBundle.getMessage(SeqCheckerTopComponent.class, "SeqCheckerTopComponent._selectButton.text")); // NOI18N
        _selectButton.setToolTipText(org.openide.util.NbBundle.getMessage(SeqCheckerTopComponent.class, "SeqCheckerTopComponent._selectButton.toolTipText_1")); // NOI18N
        _selectButton.setFocusable(false);
        _selectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        _selectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        _selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _selectButtonActionPerformed(evt);
            }
        });
        _mainToolBar.add(_selectButton);

        org.openide.awt.Mnemonics.setLocalizedText(summaryButton, org.openide.util.NbBundle.getMessage(SeqCheckerTopComponent.class, "SeqCheckerTopComponent.summaryButton.text")); // NOI18N
        summaryButton.setFocusable(false);
        summaryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        summaryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        summaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summaryButtonActionPerformed(evt);
            }
        });
        _mainToolBar.add(summaryButton);

        _mainSplitPane.setDividerLocation(300);
        _mainSplitPane.setDividerSize(5);
        _mainSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        _splitPane2.setDividerLocation(175);
        _splitPane2.setDividerSize(5);

        _constructsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Construct", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _constructsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        _constructsTable.setFillsViewportHeight(true);
        _constructsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        _constructsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                constructsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(_constructsTable);

        _splitPane2.setLeftComponent(jScrollPane1);

        _splitPane3.setDividerLocation(180);
        _splitPane3.setDividerSize(5);

        _clonesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Clone", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _clonesTable.setFillsViewportHeight(true);
        _clonesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        _clonesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clonesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(_clonesTable);

        _splitPane3.setLeftComponent(jScrollPane2);

        _primersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Primer", "Status", "Trace File"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _primersTable.setFillsViewportHeight(true);
        _primersTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        _primersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                primersTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(_primersTable);

        _splitPane3.setRightComponent(jScrollPane3);

        _splitPane2.setRightComponent(_splitPane3);

        _mainSplitPane.setTopComponent(_splitPane2);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        _mainSplitPane.setRightComponent(jPanel1);

        javax.swing.GroupLayout _mainPanelLayout = new javax.swing.GroupLayout(_mainPanel);
        _mainPanel.setLayout(_mainPanelLayout);
        _mainPanelLayout.setHorizontalGroup(
            _mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(_mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_mainToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addComponent(_mainSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
                .addContainerGap())
        );
        _mainPanelLayout.setVerticalGroup(
            _mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_mainPanelLayout.createSequentialGroup()
                .addComponent(_mainToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_mainSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 490, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void _selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__selectButtonActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(null);
        File selectedDirectory = chooser.getSelectedFile();

        String[] tokens;
        boolean constructPresent;
        boolean clonePresent;
        Construct selectedConstruct = null;
        Clone selectedClone = null;


        if (selectedDirectory != null) {
            File[] folderContents = selectedDirectory.listFiles();

            for (File file : folderContents) {
                try {
                    if (file.getName().substring(file.getName().lastIndexOf(".")).equals(".ab1")) {
                        selectedConstruct = null;
                        selectedClone = null;
                        tokens = file.getName().split("[_.]");

                        for (String token : tokens) {
                            if (token.toLowerCase().matches("[a-zA-Z]*?\\d{2,}?")) {
                                constructPresent = false;

                                for (Construct construct : _constructs) {
                                    if (token.equalsIgnoreCase(construct.getIdentifier())) {
                                        selectedConstruct = construct;
                                        constructPresent = true;
                                        break;
                                    }
                                }

                                if (!constructPresent) {
                                    selectedConstruct = new Construct(token);
                                    _constructs.add(selectedConstruct);
                                }

                                break;
                            }
                        }

                        for (String token : tokens) {
                            if (token.toLowerCase().matches("\\d+")) {
                                clonePresent = false;

                                for (Clone clone : selectedConstruct.getClones()) {
                                    if (token.equalsIgnoreCase(clone.getIdentifier())) {
                                        selectedClone = clone;
                                        clonePresent = true;
                                        break;
                                    }
                                }

                                if (!clonePresent) {
                                    selectedClone = new Clone(token);
                                    selectedConstruct.addClone(selectedClone);
                                }

                                break;
                            }
                        }

                        // TODO Needs refactoring. Simply selecting third token
                        selectedClone.addSequenceResult(new SequencingResult(tokens[2], file));
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    //folder names that don't have a '.' character well cause an exception to be thrown
                }
            }

            _constructsTable.setModel(new javax.swing.table.DefaultTableModel(generateConstructsArray(), new String[]{"Construct", "Status"}));
            _constructsTable.doLayout();
            _constructsTable.getSelectionModel().setSelectionInterval(0, 0);
            displayClones(0);

            //displayCheckSummary(_constructs);
        }
    }//GEN-LAST:event__selectButtonActionPerformed

    private void constructsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_constructsTableMouseClicked

        displayClones(_constructsTable.getSelectedRow());
    }//GEN-LAST:event_constructsTableMouseClicked

    private void clonesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clonesTableMouseClicked

        displaySequencingResults(_clonesTable.getSelectedRow());
    }//GEN-LAST:event_clonesTableMouseClicked

    private void primersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_primersTableMouseClicked

        this.displaySequenceCheck(_primersTable.getSelectedRow());
    }//GEN-LAST:event_primersTableMouseClicked

    private void summaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_summaryButtonActionPerformed
        displayCheckSummary(_constructs);
    }//GEN-LAST:event_summaryButtonActionPerformed

    protected void displayClones(int constructsTableSelectedRow) {
        String constructID = (String) _constructsTable.getValueAt(constructsTableSelectedRow, 0);

        for (Construct construct : _constructs) {
            if (constructID.equalsIgnoreCase(construct.getIdentifier())) {
                _clonesTable.setModel(new javax.swing.table.DefaultTableModel(construct.generateClonesArray(), new String[]{"Clone", "Status"}));
                _clonesTable.doLayout();
                _clonesTable.getSelectionModel().setSelectionInterval(0, 0);
                displaySequencingResults(0);
                break;
            }
        }
    }

    protected void displaySequencingResults(int clonesTableSelectedRow) {
        ArrayList<Clone> clones;
        String constructID = (String) _constructsTable.getValueAt(_constructsTable.getSelectedRow(), 0);
        String cloneID = (String) _clonesTable.getValueAt(clonesTableSelectedRow, 0);

        for (Construct construct : _constructs) {
            if (constructID.equalsIgnoreCase(construct.getIdentifier())) {
                clones = construct.getClones();

                for (Clone clone : clones) {
                    if (cloneID.equalsIgnoreCase(clone.getIdentifier())) {
                        _primersTable.setModel(new javax.swing.table.DefaultTableModel(clone.generateSequencingResultsArray(), new String[]{"Primer", "Status", "Trace File"}));
                        _primersTable.doLayout();
                        _primersTable.getSelectionModel().setSelectionInterval(0, 0);
                        displaySequenceCheck(0);
                        break;
                    }
                }

                break;
            }
        }
    }

    protected void displaySequenceCheck(int primerTableSelectedRow) {
        ArrayList<Clone> clones;
        ArrayList<SequencingResult> seqResults;
        String constructID = (String) _constructsTable.getValueAt(_constructsTable.getSelectedRow(), 0);
        String cloneID = (String) _clonesTable.getValueAt(_clonesTable.getSelectedRow(), 0);
        String traceFileName = (String) _primersTable.getValueAt(primerTableSelectedRow, 2);

        for (Construct construct : _constructs) {
            if (constructID.equalsIgnoreCase(construct.getIdentifier())) {
                clones = construct.getClones();

                for (Clone clone : clones) {
                    if (cloneID.equalsIgnoreCase(clone.getIdentifier())) {
                        seqResults = clone.getSequencingResults();

                        for (SequencingResult seqResult : seqResults) {
                            if (traceFileName.equalsIgnoreCase(seqResult.getTraceFile().getName())) {
                                //String referenceSeq = _controller.fetchConstruct(constructID);
                                _mainSplitPane.setRightComponent(_controller.check(construct));
                                _mainSplitPane.setDividerLocation(200);
                                break;
                            }
                        }

                        break;
                    }
                }

                break;
            }
        }
    }

    protected void displayCheckSummary(ArrayList<Construct> constructs) {
        StringBuilder html = new StringBuilder();
//      valid_nbr = 0
//      good = header
//      bad  = header

        html.append("<html>");

//        html.append('%s/welcome_aln.html' % output_folder, 'w')
//                h.write('Click on the links below to see alignments.')
//                h.close()
//                h = open('%s/welcome_error.html' % output_folder, 'w')
//                h.write('Click on the links below to see errors.')
//                h.close()
//                h = open('%s/GOOD/no_error.html' % output_folder, 'w')
//                h.write('No error.')
//                h.close()
//                header = """<head>
        html.append("<head>"
                + "<style type=\"text/css\">"
                + "body {background-color:#F0F0F0}"
                + "A:link {text-decoration: none; color: black}"
                + "A:visited {text-decoration: none; color: purple}"
                + "A:active {text-decoration: none}"
                + "A:hover {text-decoration: underline; color: red;}"
                + "</style>"
                + "<script language=\"javascript\">"
                + "function loadTwo(aln2URL, errorURL)"
                + "{"
                + "parent.alnFRAME.location.href=aln2URL"
                + "parent.errorFRAME.location.href=errorURL"
                + "}"
                + "</script>"
                + "</head>);");
        html.append("<body>\n<h2>Details Test</h2>\n");
        html.append("<pre>");

        for (Construct construct : _constructs) {
//                    if self[construct].isvalid:
//                        valid_nbr += 1
//                        good += '%s - ' % self[construct].id
//                        offset = '\n'+' '*len(self[construct].id)+' - '
//                        path_error = './no_error.html'
//                        good_list = []
//                        for clone in self[construct].valid:
//                            path_aln = './%s/%s.%s.html' % (self[construct].id, self[construct].id, clone.id)
//                            good_list.append("""<a href="javascript:loadTwo('%s', '%s') "target="_self">%s.%s</a> [%s]""" % (path_aln, path_error, self[construct].id, clone.id, clone.location))
//                        good += offset.join(good_list) + '\n\n'
//                    else:
//                        bad += '%s - ' % self[construct].id
//                        offset = '\n'+' '*len(self[construct].id)+' - '
//                        bad_list = []
//                        for clone in self[construct].nonvalid:
//                            path_aln = '%s.%s.html' % (self[construct].id, clone.id)
//                            path_error = '%s.%s_error.html' % (self[construct].id, clone.id)
//                            bad_list.append(""" <a href="javascript:loadTwo('./%s/%s', './%s/%s') "target="_self">%s.%s</a> [%s]""" % (self[construct].id, path_aln, self[construct].id, path_error, self[construct].id, clone.id, clone.location))
//                            errors_summary = ''
//                            errors_local = '%s.%s' % (self[construct].id, clone.id)
//                            if clone.alns:
//                                for error_type in ('substitution','insertion','deletion','arrangement','coverage'):
//                                    if clone.errors_range[error_type]['nbr'] == 1:
//                                        errors_summary += """ 1 %s error: <a href="javascript:loadTwo('./%s/%s#error%i-%i', './%s/%s')">%i-%i</a>""" % (error_type, self[construct].id, path_aln, clone.errors_range[error_type]['bg'][0]+1, clone.errors_range[error_type]['end'][0], self[construct].id, path_error, clone.errors_range[error_type]['bg'][0]+1, clone.errors_range[error_type]['end'][0])
//                                        errors_local   += """1 %s error: <a href="./%s#error%i-%i" target="alnFRAME">%i-%i</a>""" % (error_type, path_aln, clone.errors_range[error_type]['bg'][0]+1, clone.errors_range[error_type]['end'][0], clone.errors_range[error_type]['bg'][0]+1, clone.errors_range[error_type]['end'][0])
//                                    elif clone.errors_range[error_type]['nbr']:
//                                        errors_summary += ' %i %s errors :' % (clone.errors_range[error_type]['nbr'], error_type)
//                                        errors_local   += ' - %i %s errors :' % (clone.errors_range[error_type]['nbr'], error_type)
//                                        for i in range(clone.errors_range[error_type]['nbr']):
//                                            errors_summary += """ <a href="javascript:loadTwo('./%s/%s#error%i-%i', './%s/%s')">%i-%i</a>""" % (self[construct].id, path_aln, clone.errors_range[error_type]['bg'][i]+1, clone.errors_range[error_type]['end'][i], self[construct].id, path_error, clone.errors_range[error_type]['bg'][i]+1, clone.errors_range[error_type]['end'][i])
//                                            errors_local   += """ <a href="./%s#error%i-%i" target="alnFRAME">%i-%i</a>""" % (path_aln, clone.errors_range[error_type]['bg'][i]+1, clone.errors_range[error_type]['end'][i], clone.errors_range[error_type]['bg'][i]+1, clone.errors_range[error_type]['end'][i])
//                            else:
//                                errors_summary += 'No alignments..'
//                                errors_local += 'No alignments..'
//                            bad_list[-1] += ' ('+errors_summary+')'
//                            h = open('%s/BAD/%s/%s.%s_error.html' % (output_folder, self[construct].id, self[construct].id, clone.id), 'w')
//                            h.write("""<head>
        }
//         <style>
//          A:link {text-decoration: none; color: black}
//          A:visited {text-decoration: none; color: purple}
//          A:active {text-decoration: none}
//          A:hover {text-decoration: underline; color: red;}
//         </style>
//        </head>
//        <body>
//        %s
//        </body>""" % errors_local)
//                            h.close()
//                        bad += offset.join(bad_list) + '\n\n'
//                h = open('%s/GOOD/good.html' % output_folder, 'w')
//                h.write('%s\n</pre>\n</body>' % good)
//                h.close()
//                h = open('%s/BAD/bad.html' % output_folder, 'w')
//                h.write('%s\n</pre>\n</body>' % bad)
//                h.close()
//                h = open('%s/summary.html' % output_folder, 'w')
//                h.write("""<head>
//        <title>Sequence Checker Summary</title>
//        <style type="text/css">
//        body {background-color:#F0F0F0}
//        h1 {margin:0px 0px 0px 0px;font-size:2em; font-weight:bold; color:white; background-color:#000000}
//        h2 {margin:3em 0px 0px 0px; padding: 0px 0px 0px 0px; font-size:1.5em; font-weight:bold; color:white; background-color:#413839; border-color:black;}
//        h3 {margin:0px 0px 0px 0px; padding: 0px 0px 0px 0px; font-size:1.25em; font-weight:bold; color:white; background-color:#6D7B8D; border-color:black;}
//        </style>
//        </head>
//        <body>
//        <iframe name="alnFRAME" src="./welcome_aln.html" width="100%%" frameborder="0">Sorry, your browser does not support iFrames...</iframe>
//        <iframe name="errorFRAME" src="./welcome_error.html" height="5%%" width="100%%" frameborder="0">Sorry, your browser does not support iFrames...</iframe>
//        <pre>
//        <h1> :-) GOOD (%s/%s)</h1>
//        <iframe name="good" src="./GOOD/good.html" height="30%%" width="100%%" frameborder="1" border-color="black">Sorry, your browser does not support iFrames...</iframe><br />
//        <h1> :-( BAD (%s/%s)</h1>
//        <iframe name="good" src="./BAD/bad.html"  height="30%%" width="100%%" frameborder="1" border-color="black">Sorry, your browser does not support iFrames...</iframe>
//        """ % (valid_nbr, len(self.constructs), len(self.constructs)-valid_nbr, len(self.constructs)))
//                h.close()

        html.append("</html>\n</body>\n");

        InputStream inputStream = null;
        URL url = null;
        HttpURLConnection connection = null;
        String seq = "";

        try {
            url = new URL("http://biofab.jbei.org/python/checkseq_output/summary.html");
            inputStream = url.openStream();
            seq = new Scanner(inputStream).useDelimiter("\\A").next();
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

        _htmlPane.setText(seq);
        _mainSplitPane.setRightComponent(_scrollPane4);
        _mainSplitPane.setDividerLocation(200);
    }

    protected void addHTMLPane() {
        _htmlPane = new JEditorPane();
        _htmlPane.setEditable(false);
        _scrollPane4 = new JScrollPane(_htmlPane);
        HTMLEditorKit kit = new HTMLEditorKit();
        _htmlPane.setEditorKit(kit);

//        StyleSheet styleSheet = kit.getStyleSheet();
//        styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
//        styleSheet.addRule("h1 {color: blue;}");
//        styleSheet.addRule("h2 {color: #ff0000;}");
//        styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");

        String htmlString = "<html>\n"
                + "<body>\n"
                + "<h2>Sequence Check Details</h2>\n"
                + "<p>The DNA sequence level details of a check are displayed in this space.</p>\n"
                + "</body>\n";

        Document doc = kit.createDefaultDocument();
        _htmlPane.setDocument(doc);
        _htmlPane.setText(htmlString);

        _mainSplitPane.setRightComponent(_scrollPane4);
        _mainSplitPane.setDividerLocation(200);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JTable _clonesTable;
    protected javax.swing.JTable _constructsTable;
    protected javax.swing.JPanel _mainPanel;
    protected javax.swing.JSplitPane _mainSplitPane;
    protected javax.swing.JToolBar _mainToolBar;
    protected javax.swing.JTable _primersTable;
    protected javax.swing.JButton _selectButton;
    protected javax.swing.JSplitPane _splitPane2;
    protected javax.swing.JSplitPane _splitPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    protected javax.swing.JButton summaryButton;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized SeqCheckerTopComponent getDefault() {
        if (instance == null) {
            instance = new SeqCheckerTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the SeqCheckerTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized SeqCheckerTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(SeqCheckerTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof SeqCheckerTopComponent) {
            return (SeqCheckerTopComponent) win;
        }
        Logger.getLogger(SeqCheckerTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    Object readProperties(java.util.Properties p) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(p);
        return instance;
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }
}
