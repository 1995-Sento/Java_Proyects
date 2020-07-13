package es.eduardsanz.pestanas;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eduard on 09/11/2015.
 */
public class texto implements Parcelable{
    private String Titulo;
    private String Contenido;


    protected texto(Parcel in) {
        Titulo = in.readString();
        Contenido = in.readString();
    }

    public static final Creator<texto> CREATOR = new Creator<texto>() {
        @Override
        public texto createFromParcel(Parcel in) {
            return new texto(in);
        }

        @Override
        public texto[] newArray(int size) {
            return new texto[size];
        }
    };

    public texto() {

    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable's
     * marshalled representation.
     *
     * @return a bitmask indicating the set of special object types marshalled
     * by the Parcelable.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Titulo);
        dest.writeString(Contenido);
    }
}
