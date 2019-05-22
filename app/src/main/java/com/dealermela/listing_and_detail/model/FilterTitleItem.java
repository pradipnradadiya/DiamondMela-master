package com.dealermela.listing_and_detail.model;

public class FilterTitleItem {
    private String id,icon,title,arrow,back_color,text_color,arrow_visible;

    public FilterTitleItem(String id, String icon, String title, String arrow, String back_color, String text_color, String arrow_visible) {
        this.id = id;
        this.icon = icon;
        this.title = title;
        this.arrow = arrow;
        this.back_color = back_color;
        this.text_color = text_color;
        this.arrow_visible = arrow_visible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArrow() {
        return arrow;
    }

    public void setArrow(String arrow) {
        this.arrow = arrow;
    }

    public String getBack_color() {
        return back_color;
    }

    public void setBack_color(String back_color) {
        this.back_color = back_color;
    }

    public String getText_color() {
        return text_color;
    }

    public void setText_color(String text_color) {
        this.text_color = text_color;
    }

    public String getArrow_visible() {
        return arrow_visible;
    }

    public void setArrow_visible(String arrow_visible) {
        this.arrow_visible = arrow_visible;
    }
}
