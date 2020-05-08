import java.sql.*;

public class AkilliCihazPostgreSQL {

    private static AkilliCihazPostgreSQL akilliCihazPostgreSQL=null;

    public static AkilliCihazPostgreSQL getAkilliCihazPostgreSQL() {
        if(akilliCihazPostgreSQL==null)
            akilliCihazPostgreSQL=new AkilliCihazPostgreSQL();
        return akilliCihazPostgreSQL;
    }

    private static Connection baglan(){
        Connection conn=null;

        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/OdevProje",
                    "postgres", "1234");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static boolean kullaniciKontrol(String kAdi, String kSifre) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;

        String sorgu="SELECT * FROM   kullanici where kullaniciadi = ? AND sifre= ?";
        ps=AkilliCihazPostgreSQL.baglan().prepareStatement(sorgu);

        ps.setString(1,kAdi);
        ps.setString(2,kSifre);
        rs=ps.executeQuery();
        boolean durum= rs.next();
        ps.close();
        rs.close();
        return durum;


        }
    }


