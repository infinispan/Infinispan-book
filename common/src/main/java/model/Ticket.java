package model;

public class Ticket implements java.io.Serializable {
   private String name;
   private String show;

   public Ticket(String name, String show) {
      this.name = name;
      this.show = show;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getShow() {
      return show;
   }

   public void setShow(String show) {
      this.show = show;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Ticket ticket = (Ticket) o;

      if (name != null ? !name.equals(ticket.name) : ticket.name != null) return false;
      if (show != null ? !show.equals(ticket.show) : ticket.show != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = name != null ? name.hashCode() : 0;
      result = 31 * result + (show != null ? show.hashCode() : 0);
      return result;
   }

   @Override
   public String toString() {
      return "Ticket{" +
            "name='" + name + '\'' +
            ", show='" + show + '\'' +
            '}';
   }
}
