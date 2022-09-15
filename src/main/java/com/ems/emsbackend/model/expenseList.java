package com.ems.emsbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class expenseList {

    @Id
    @GeneratedValue
    private Long id;
    private String employee_no;
    private String full_name;
    private String application_date_from;
    private String application_date_to;
    private String approval_month_from;
    private String approval_month_to;
    private String payment_date_from;
    private String payment_date_to;
    private String approval_status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getApplication_date_from() {
        return application_date_from;
    }

    public void setApplication_date_from(String application_date_from) {
        this.application_date_from = application_date_from;
    }

    public String getApplication_date_to() {
        return application_date_to;
    }

    public void setApplication_date_to(String application_date_to) {
        this.application_date_to = application_date_to;
    }

    public String getApproval_month_from() {
        return approval_month_from;
    }

    public void setApproval_month_from(String approval_month_from) {
        this.approval_month_from = approval_month_from;
    }

    public String getApproval_month_to() {
        return approval_month_to;
    }

    public void setApproval_month_to(String approval_month_to) {
        this.approval_month_to = approval_month_to;
    }

    public String getPayment_date_from() {
        return payment_date_from;
    }

    public void setPayment_date_from(String payment_date_from) {
        this.payment_date_from = payment_date_from;
    }

    public String getPayment_date_to() {
        return payment_date_to;
    }

    public void setPayment_date_to(String payment_date_to) {
        this.payment_date_to = payment_date_to;
    }

    public String getApproval_status() {
        return approval_status;
    }

    public void setApproval_status(String approval_status) {
        this.approval_status = approval_status;
    }
}
