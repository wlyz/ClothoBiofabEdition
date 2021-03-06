/*
 Copyright (c) 2009 The Regents of the University of California.
 All rights reserved.
 Permission is hereby granted, without written agreement and without
 license or royalty fees, to use, copy, modify, and distribute this
 software and its documentation for any purpose, provided that the above
 copyright notice and the following two paragraphs appear in all copies
 of this software.

 IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY
 FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
 ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
 THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
 SUCH DAMAGE.

 THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
 INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
 PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
 CALIFORNIA HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
 ENHANCEMENTS, OR MODIFICATIONS..
 */

package org.clothocad.tool.institutioneditor;

import java.awt.Window;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.clothocore.api.core.Collector;
import org.clothocore.api.data.Institution;
import org.clothocore.api.data.Lab;
import org.clothocore.api.data.ObjBase;
import org.clothocore.api.data.ObjLink;
import org.clothocore.api.data.ObjType;
import org.clothocore.api.plugin.ClothoTool;

/**
 *
 * @author J. Christopher Anderson
 */
public class connect implements ClothoTool {

    @Override
    public void launch() {
        if(!Collector.isConnected()) {
            JOptionPane.showMessageDialog( null, "Database connection required to launch Institution Editor!",
                                           "Not connected", JOptionPane.ERROR_MESSAGE );
            return;
        }

        //Throw up a dialog and get user to select the collection stored as 'chosen'
        ArrayList<ObjLink> allColl = Collector.getAllLinksOf(ObjType.INSTITUTION);
        Object[] allNames = allColl.toArray();
        Object[] param = new Object[allNames.length+1];
        param[0] = "New Institution";
        for(int i=0; i<allNames.length; i++) {
            param[i+1] = allNames[i];
        }
        Object val = JOptionPane.showInputDialog(null, "Choose one", "Collection",
            JOptionPane.INFORMATION_MESSAGE, null, param, param[0]);
        
        if(val==null) {
            return;
        }

        //If new Institution chosen, create a new Institution
        if(val.equals(param[0])) {
            //Get a name and leave other fields blank
            String instname = JOptionPane.showInputDialog( "What is the name of the new Institution?" );
            if(instname==null) {
                return;
            }
            Institution chosen = new Institution(instname,"","","");
            launch(chosen);
            return;
        }

        ObjLink link = (ObjLink) val;
        if(link!=null) {
            Institution chosen = Collector.getInstitution(link.uuid);
            launch(chosen);
        }
    }

    @Override
    public void launch(ObjBase o) {
        if(!o.getType().equals(ObjType.INSTITUTION)) {
            return;
        }
        if(!Collector.isConnected()) {
            JOptionPane.showMessageDialog( null, "Database connection required to launch this tool",
                                           "Not connected", JOptionPane.ERROR_MESSAGE );
            return;
        }
        pig.add(new WeakReference(new frame((Institution) o)));
    }


    @Override
    public void close() {
        for(WeakReference<Window> wf: pig) {
            Window gui = (Window) wf.get();
            if(gui!=null) {
                gui.dispose();
            }
        }
    }

    @Override
    public void init() {
    }

/*-----------------
     variables
 -----------------*/
        private ArrayList<WeakReference<Window>> pig= new ArrayList<WeakReference<Window>>();

}
