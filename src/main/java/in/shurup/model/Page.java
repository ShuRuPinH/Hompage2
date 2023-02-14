package in.shurup.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Сущность котору
 */
public class Page implements Serializable {

    public String text;

    List ways;

    public Page(String text, List<Way> ways) {
        this.text = text;
        this.ways = ways;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List <Way> getWays() {
        return ways;
    }

    public void setWays(List ways) {
        this.ways = ways;
    }

    public Page() {
        text = "Empty // Пусто";
        ways = List.of(new Way());
    }

    @Override
    public String toString() {
        return "Page{" +
                "text='" + text + '\'' +
                ", ways=" + ways +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Page)) return false;
        Page page = (Page) o;
        return Objects.equals(text, page.text) && Objects.equals(ways, page.ways);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, ways);
    }
}
