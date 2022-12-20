/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.laundrymanagementsystem;

import static java.lang.Float.parseFloat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static lms.gen.Tables.CUSTOMER;
import static lms.gen.Tables.EMPLOYEE;
import static lms.gen.Tables.LAUNDRY;
import static lms.gen.Tables.CLOTHING_ITEMS;
import static lms.gen.Tables.PRODUCT_ITEMS;
import static lms.gen.Tables.LAUNDRY_PRICE;
import static lms.gen.Tables.PRODUCT;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jooq.Result;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.TableField;
/**
 *
 * @author Jericho Opsima
 */
public class AddLaundry extends javax.swing.JDialog {
    
    DefaultTableModel productTableModel;
    DefaultTableModel laundryItemTableModel;

    /**
     * Creates new form AddLaundry
     */
    public AddLaundry(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        populateDropdown(LAUNDRY_PRICE.LAUNDRY_TYPE, laundryTypeDropdown, "LP");
        populateDropdown(LAUNDRY_PRICE.SERVICE_NAME, serviceDropdown, "LP");
        populateDropdown(PRODUCT.PRODUCT_NAME, productItemDropdown, "");
        populateEmployeeDropdown();
        populateCustomerDropdown();
        this.laundryItemTableModel = (DefaultTableModel) clothingItemTable.getModel();
        this.productTableModel = (DefaultTableModel) productTable.getModel();
        amountTenderedField.setEnabled(false); //toggle it to true when add button is clicked
        
        AutoCompleteDecorator.decorate(this.employeeDropdown);
        AutoCompleteDecorator.decorate(this.customerDropdown);
        AutoCompleteDecorator.decorate(this.laundryTypeDropdown);
        AutoCompleteDecorator.decorate(this.productItemDropdown);
        
    }
    
    private void populateDropdown(TableField tf, JComboBox cb, String table_name) {
        Result<Record> res;
        
        if (table_name.equals("LP")) {
            res = Database.context().selectDistinct(tf).from(LAUNDRY_PRICE).fetch();
        } else {
            res = Database.context().select(tf).from(PRODUCT).fetch();
        }
                
        for (Record r : res) {
            cb.addItem(r.get(tf));
        }

    }
    
    private void populateEmployeeDropdown() {
        var res = Database.context().select(
                EMPLOYEE.EMPLOYEE_NAME)
                .from(EMPLOYEE)
                .fetch();
        
        for (Record r : res) {
            employeeDropdown.addItem((String) r.get(EMPLOYEE.EMPLOYEE_NAME));
        }
    }
    
    private void populateCustomerDropdown() {
        var res = Database.context()
                .select(CUSTOMER.CUSTOMER_NAME)
                .from(CUSTOMER)
                .fetch();
        
        for (Record r : res) {
            customerDropdown.addItem((String) r.get(CUSTOMER.CUSTOMER_NAME));
        }
    }
    
    private void populateDashboardTable() {
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        customerDropdown = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        laundryTypeDropdown = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        productItemDropdown = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        clothingItemTable = new javax.swing.JTable();
        addClothingBtn = new javax.swing.JButton();
        addProductItemBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addLaundryBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        totalAmountLabel = new javax.swing.JLabel();
        changeLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        removeLaundryItemBtn = new javax.swing.JButton();
        removeProductItemBtn = new javax.swing.JButton();
        paymentStatusDropdown = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        employeeDropdown = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        serviceDropdown = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        deliveryDropdown = new javax.swing.JComboBox<>();
        laundryQuantitySpinner = new javax.swing.JSpinner();
        productQuantitySpinner = new javax.swing.JSpinner();
        dateInput = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        paymentHistoryBtn = new javax.swing.JButton();
        amountTenderedField = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Customer");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Clothing Type");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Quantity");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Product Item");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Quantity");

        clothingItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clothing Type", "Service", "Quantity", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(clothingItemTable);

        addClothingBtn.setText("Add");
        addClothingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClothingBtnActionPerformed(evt);
            }
        });

        addProductItemBtn.setText("Add");
        addProductItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductItemBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Amount Tendered");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Change");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Total");

        addLaundryBtn.setBackground(new java.awt.Color(204, 204, 255));
        addLaundryBtn.setText("Add Laundry");
        addLaundryBtn.setActionCommand("");
        addLaundryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLaundryBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(255, 0, 0));
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        totalAmountLabel.setText("0");

        changeLabel.setText("0");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Service");

        removeLaundryItemBtn.setText("Remove");

        removeProductItemBtn.setText("Remove");

        paymentStatusDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Yet Paid", "Partial Payment", "Paid" }));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Assign Employee");

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Quantity ", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productTable);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Payment Status");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Delivery Method");

        deliveryDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pick-up", "Drop off" }));

        laundryQuantitySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        productQuantitySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Date");

        paymentHistoryBtn.setText("View Payment History");
        paymentHistoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentHistoryBtnActionPerformed(evt);
            }
        });

        amountTenderedField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                amountTenderedFieldFocusLost(evt);
            }
        });
        amountTenderedField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                amountTenderedFieldMouseExited(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(56, 56, 56)
                                .addComponent(customerDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(employeeDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(productItemDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(productQuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addProductItemBtn)
                                .addGap(18, 18, 18)
                                .addComponent(removeProductItemBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(paymentStatusDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(paymentHistoryBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(laundryTypeDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(laundryQuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(serviceDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(addClothingBtn)
                        .addGap(18, 18, 18)
                        .addComponent(removeLaundryItemBtn))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addLaundryBtn)
                        .addGap(27, 27, 27)
                        .addComponent(cancelBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(totalAmountLabel))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amountTenderedField))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(changeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(refresh)
                                .addGap(94, 94, 94)
                                .addComponent(jLabel10))
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deliveryDropdown, 0, 121, Short.MAX_VALUE)
                            .addComponent(dateInput))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(paymentStatusDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(customerDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(employeeDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paymentHistoryBtn))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addClothingBtn)
                                    .addComponent(removeLaundryItemBtn))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(laundryTypeDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(laundryQuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serviceDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addProductItemBtn)
                                .addComponent(removeProductItemBtn))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(productQuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(productItemDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(deliveryDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(totalAmountLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(dateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(changeLabel)
                                            .addComponent(amountTenderedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refresh)
                        .addGap(80, 80, 80)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addLaundryBtn)
                    .addComponent(cancelBtn))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addClothingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClothingBtnActionPerformed
        int quantity = (int) laundryQuantitySpinner.getValue();
        
        try {
            laundryQuantitySpinner.commitEdit();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        
        String service = (String) serviceDropdown.getSelectedItem();
        String laundryType = (String) laundryTypeDropdown.getSelectedItem();
        
        var getPrice = Database.context()
                .select(LAUNDRY_PRICE.PRICE)
                .from(LAUNDRY_PRICE)
                .where(LAUNDRY_PRICE.SERVICE_NAME.eq(service))
                .and(LAUNDRY_PRICE.LAUNDRY_TYPE.eq(laundryType))
                .fetchSingle();

        int multiplyPrice = (int) (getPrice.get(LAUNDRY_PRICE.PRICE) * quantity);

        var rowData = new Object[4];
        rowData[0] = laundryType;
        rowData[1] = service;
        rowData[2] = quantity;
        rowData[3] = multiplyPrice;
        
        laundryItemTableModel.addRow(rowData);     
        
        
        float getTotal = parseFloat(totalAmountLabel.getText()) + multiplyPrice;
        
        totalAmountLabel.setText(String.valueOf(getTotal));
        amountTenderedField.setEnabled(true);
    }//GEN-LAST:event_addClothingBtnActionPerformed

    private void addProductItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductItemBtnActionPerformed
        int quantity = (int) productQuantitySpinner.getValue();
        
        // Get quantity value
        try {
            productQuantitySpinner.commitEdit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Get Product Item
        String productItem = (String) productItemDropdown.getSelectedItem();
        
        // Get product price from DB
        var getPrice = Database.context()
                .select(PRODUCT.UNIT_PRICE)
                .from(PRODUCT)
                .where(PRODUCT.PRODUCT_NAME.eq(productItem))
                .fetchSingle();
        
        int multiplyPrice = (int) (getPrice.get(PRODUCT.UNIT_PRICE) * quantity);
        
        var rowData = new Object[3];
        rowData[0] = productItem;
        rowData[1] = quantity;
        rowData[2] = multiplyPrice;
        
        productTableModel.addRow(rowData);
        
        float getTotal = parseFloat(totalAmountLabel.getText()) + multiplyPrice;
        
        totalAmountLabel.setText(String.valueOf(getTotal));
    }//GEN-LAST:event_addProductItemBtnActionPerformed

    private void addLaundryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLaundryBtnActionPerformed
        
        // CUSTOMER
        // ================================================================================
        var getCustomer = customerDropdown.getSelectedItem().toString();
        var getCustomerID = Database.context()
                .select(CUSTOMER.CUSTOMER_ID)
                .from(CUSTOMER)
                .where(CUSTOMER.CUSTOMER_NAME.eq(getCustomer))
                .fetchSingle();
        
        var extractCustomerID = getCustomerID.get(CUSTOMER.CUSTOMER_ID);
        // ================================================================================
        
        
        // EMPLOYEE
        // ================================================================================
        var getEmployeeFromDropdown = employeeDropdown.getSelectedItem().toString();
        var getEmployeeID = Database.context()
                .select(EMPLOYEE.EMPLOYEE_ID)
                .from(EMPLOYEE)
                .where(EMPLOYEE.EMPLOYEE_NAME.eq(getEmployeeFromDropdown))
                .fetchSingle();
        
        var extractEmployeeID = getCustomerID.get(CUSTOMER.CUSTOMER_ID);
        // ================================================================================

        
        var paymentStatus = paymentStatusDropdown.getSelectedIndex();
        var totalAmount = parseFloat(totalAmountLabel.getText());
        var amountTendered = parseFloat(amountTenderedField.getText());
        var deliveryMethod = (String) deliveryDropdown.getSelectedItem();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        var dateAdded = formatter.format(date);
        
        // Add Laundry Order to Database
        Database.context()
                .insertInto(
                        LAUNDRY,
                        LAUNDRY.CUSTOMER_ID,
                        LAUNDRY.ASSIGNED_EMPLOYEE_ID,
                        LAUNDRY.AMOUNT_TENDERED,
                        LAUNDRY.TOTAL_AMOUNT,
                        LAUNDRY.DATE_ADDED,
                        LAUNDRY.PAYMENT_STATUS,
                        LAUNDRY.DELIVERY_METHOD)
                .values(extractCustomerID, extractEmployeeID, amountTendered, totalAmount, dateAdded, paymentStatus, deliveryMethod)
                .execute();
        
        
        //  ==============================Add the rows from two tables in the database==============================
        
        
        // ====================
        // Clothing Type Table 
        // ====================
        int clothingItemRowCount = clothingItemTable.getRowCount();
        
        for (int row = 0; row < clothingItemRowCount; row++) {
            List<Object> rowData = new ArrayList<>();
            for (int column = 0; column < clothingItemTable.getColumnCount(); column++) {
                //Get and add Laundry ID
                rowData.add((int) Database.context()
                        .select(LAUNDRY.LAUNDRY_ID)
                        .from(LAUNDRY)
                        .orderBy(LAUNDRY.LAUNDRY_ID.desc())
                        .fetchOne()
                        .get(LAUNDRY.LAUNDRY_ID));
                
                rowData.add(clothingItemTable.getValueAt(row, column));
            }
            Database.context().insertInto(CLOTHING_ITEMS).values(rowData).execute();
        }

        // ====================
        // Product Item Table   
        // ====================
        int productRowCount = productTableModel.getRowCount();
        
        for (int row = 0; row < productRowCount; row++) {
            List<Object> rowData = new ArrayList<>();
            for (int column = 0; column < productTableModel.getColumnCount(); column++) {
                //Get Laundry ID
                rowData.add((int) Database.context().select(LAUNDRY.LAUNDRY_ID).from(LAUNDRY).orderBy(LAUNDRY.LAUNDRY_ID.desc()).fetchOne().get(LAUNDRY.LAUNDRY_ID));
                
                rowData.add(productTable.getValueAt(row, column));
            }
            Database.context().insertInto(PRODUCT_ITEMS).values(rowData).execute();
        }
        
        //Populate Laundry Table
//        populateLaundryTable();
        
        
        // Reduce quantitty
        
        Record1<Integer> getCurrentQuantity = Database.context().select(PRODUCT.QUANTITY).from(PRODUCT).fetchOne();
        
        int productStockQuantity = getCurrentQuantity.get(0, int.class);
        
        if (productStockQuantity > 0) {

            int quantity = (Integer) laundryQuantitySpinner.getValue();
            if (quantity > productStockQuantity)

            Database.context().update(PRODUCT).set(PRODUCT.QUANTITY, productStockQuantity - quantity).execute();            
        } else {
            JOptionPane.showMessageDialog(this, "Not Enough Stocks.");
        }
        


    }//GEN-LAST:event_addLaundryBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void paymentHistoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentHistoryBtnActionPerformed
        new PaymentHistory(null, true).setVisible(true);
    }//GEN-LAST:event_paymentHistoryBtnActionPerformed

    private void amountTenderedFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amountTenderedFieldMouseExited
//        var getTotal = parseFloat(totalAmountLabel.getText()) - parseFloat(amountTenderedField.getText());
//        changeLabel.setText(String.valueOf(getTotal));
    }//GEN-LAST:event_amountTenderedFieldMouseExited

    private void amountTenderedFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountTenderedFieldFocusLost
        var getTotal = parseFloat(totalAmountLabel.getText()) - parseFloat(amountTenderedField.getText());
        changeLabel.setText(String.valueOf(getTotal));
    }//GEN-LAST:event_amountTenderedFieldFocusLost

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddLaundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddLaundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddLaundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddLaundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddLaundry dialog = new AddLaundry(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addClothingBtn;
    private javax.swing.JButton addLaundryBtn;
    private javax.swing.JButton addProductItemBtn;
    private javax.swing.JTextField amountTenderedField;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel changeLabel;
    private javax.swing.JTable clothingItemTable;
    private javax.swing.JComboBox<String> customerDropdown;
    private javax.swing.JTextField dateInput;
    private javax.swing.JComboBox<String> deliveryDropdown;
    private javax.swing.JComboBox<String> employeeDropdown;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable2;
    private javax.swing.JSpinner laundryQuantitySpinner;
    private javax.swing.JComboBox<String> laundryTypeDropdown;
    private javax.swing.JButton paymentHistoryBtn;
    private javax.swing.JComboBox<String> paymentStatusDropdown;
    private javax.swing.JComboBox<String> productItemDropdown;
    private javax.swing.JSpinner productQuantitySpinner;
    private javax.swing.JTable productTable;
    private javax.swing.JButton refresh;
    private javax.swing.JButton removeLaundryItemBtn;
    private javax.swing.JButton removeProductItemBtn;
    private javax.swing.JComboBox<String> serviceDropdown;
    private javax.swing.JLabel totalAmountLabel;
    // End of variables declaration//GEN-END:variables
}
