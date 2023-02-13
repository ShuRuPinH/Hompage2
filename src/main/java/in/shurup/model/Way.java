package in.shurup.model;

import java.util.Objects;

public class Way {
    String pos;
    String name;
    String hint;


    public Way(String pos, String name, String hint) {
        this.pos = pos;
        this.name = name;
        this.hint = hint;
    }
    public Way() {
        pos="11";
        name = "return to enter /<t>вернуться к началу</t> ";
        hint ="0";
    }

    @Override
    public String toString() {
        return "Way{" +
                "pos=" + pos +
                ", description='" + hint + '\'' +
                '}';
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Way)) return false;
        Way way = (Way) o;
        return Objects.equals(pos, way.pos) && Objects.equals(name, way.name) && Objects.equals(hint, way.hint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos, name, hint);
    }
}
