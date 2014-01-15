/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JqGridData<T> {

    /**
     * Total number of pages
     */
    private int total;
    /**
     * The current page number
     */
    private int page;
    /**
     * Total number of records
     */
    private int records;
    /**
     * The actual data
     */
    private List<T> rows;

    public JqGridData(int total, int page, int records, List<T> rows) {
        this.total = total;
        this.page = page;
        this.records = records;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getRecords() {
        return records;
    }

    public List<T> getRows() {
        return rows;
    }

}