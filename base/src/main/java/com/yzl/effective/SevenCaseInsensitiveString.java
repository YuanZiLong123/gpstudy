package effective;

public final class SevenCaseInsensitiveString {

    private String s;

    public SevenCaseInsensitiveString(String s) {
        if (s == null)
            throw  new NullPointerException();
        this.s = s;
    }

    public boolean equals(Object o){

        return  o instanceof  SevenCaseInsensitiveString&&
                ((SevenCaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }

}
