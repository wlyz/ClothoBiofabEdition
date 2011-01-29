/*
 * File: SeqDesignerPanel.ui.js
 * Date: Tue Nov 30 2010 20:50:38 GMT-0800 (PST)
 * 
 * This file was generated by Ext Designer version xds-1.0.2.14.
 * http://www.extjs.com/products/designer/
 *
 * This file will be auto-generated each and everytime you export.
 *
 * Do NOT hand edit this file.
 */

SeqDesignerPanelUi = Ext.extend(Ext.Panel, {
    title: 'Sequence Designer',
    closable: true,
    layout: 'border',
    id: 'seqDesignerPanel',
    initComponent: function() {
        this.items = [
            {
                xtype: 'panel',
                title: 'Parameters',
                height: 200,
                layout: 'absolute',
                region: 'center',
                id: 'parametersPanel',
                items: [
                    {
                        xtype: 'displayfield',
                        value: 'Input Sequence:',
                        width: 130,
                        x: 10,
                        y: 10
                    },
                    {
                        xtype: 'displayfield',
                        value: 'Standard:',
                        width: 115,
                        x: 10,
                        y: 35
                    },
                    {
                        xtype: 'combo',
                        x: 145,
                        y: 35,
                        store: 'refineStdStore',
                        displayField: 'name',
                        valueField: 'id',
                        title: 'Refinement Standard',
                        editable: false,
                        emptyText: 'Select a Refinement Standard',
                        height: 100,
                        width: 245,
                        ref: '../refineStdComboBox',
                        id: 'refineStdComboBox'
                    },
                    {
                        xtype: 'displayfield',
                        value: 'Prefix:',
                        width: 65,
                        x: 10,
                        y: 60
                    },
                    {
                        xtype: 'displayfield',
                        value: 'Suffix:',
                        width: 60,
                        x: 10,
                        y: 85
                    },
                    {
                        xtype: 'textfield',
                        x: 145,
                        y: 60,
                        width: 245
                    },
                    {
                        xtype: 'textfield',
                        x: 145,
                        y: 85,
                        width: 245
                    },
                    {
                        xtype: 'textfield',
                        x: 145,
                        y: 10,
                        width: 245
                    },
                    {
                        xtype: 'combo',
                        x: 395,
                        y: 60,
                        width: 90,
                        store: 'refineStdStore'
                    },
                    {
                        xtype: 'combo',
                        x: 395,
                        y: 85,
                        width: 90,
                        store: 'refineStdStore'
                    },
                    {
                        xtype: 'displayfield',
                        value: 'Coding Region:',
                        width: 125,
                        x: 10,
                        y: 115
                    },
                    {
                        xtype: 'checkbox',
                        x: 145,
                        y: 110
                    },
                    {
                        xtype: 'combo',
                        x: 145,
                        y: 135,
                        width: 135,
                        store: 'refineStdStore'
                    },
                    {
                        xtype: 'displayfield',
                        value: 'Codon Pref:',
                        width: 85,
                        x: 10,
                        y: 140
                    }
                ]
            },
            {
                xtype: 'panel',
                title: 'Result',
                height: 400,
                layout: 'fit',
                region: 'south',
                ref: 'resultPanel',
                id: 'resultPanel',
                items: [
                    {
                        xtype: 'textarea',
                        region: 'center',
                        split: true,
                        ref: '../resultTextArea',
                        id: 'resultTextArea'
                    }
                ]
            }
        ];
        SeqDesignerPanelUi.superclass.initComponent.call(this);
    }
});