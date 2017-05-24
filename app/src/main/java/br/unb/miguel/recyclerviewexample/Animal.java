package br.unb.miguel.recyclerviewexample;

/**
 * Created by Miguel on 24/05/2017.
 */

public class Animal {

    private String _name;
    private String _description;
    private int _imageFileDrawable;

    /**
     * Constructor of the class
     * @param name  Name of the animal
     * @param description   Description of the animal
     * @param imageFileDrawable  Reference to image's file
     */
    public Animal(String name, String description, int imageFileDrawable){
        _name = name;
        _description = description;
        _imageFileDrawable = imageFileDrawable;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public int get_imageFileDrawable() {
        return _imageFileDrawable;
    }

    public void set_imageFileDrawable(int _imageFileDrawable) {
        this._imageFileDrawable = _imageFileDrawable;
    }
}
