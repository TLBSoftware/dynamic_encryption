package com.taylor.notetaker;

/**
 * Created by Tnayr on 8/3/2016.
 */
public class Notes {
    private int _id;
    private String _title;
    private String _message;

    public Notes(){}

    public Notes(int _id, String _title, String _message) {
        this._id = _id;
        this._title = _title;
        this._message = _message;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_message() {
        return _message;
    }

    public void set_message(String _message) {
        this._message = _message;
    }
}
