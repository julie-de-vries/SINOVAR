/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

/**
 *
 * @author Julie
 */
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class DataBaseLayer {

    private ArrayList<ArrayList<String>> result = new ArrayList<>();
    private int modification;
    private Connection connexion;
            
    public DataBaseLayer(String requete) {
        //Récupération des données SQL
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            /* Gérer les éventuelles erreurs ici. */
            e.printStackTrace();
        }
        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/database_sinovar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "Julie";
        String password = "sinovAr4";
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        try {
            statement = connexion.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            /* Création de l'objet gérant les requêtes */
 /* Exécution d'une requête de lecture */
            if (requete.toUpperCase().startsWith("SELECT")) {
                /*selon si la requête est une lecture ou une modification*/
                ResultSet resultSet = statement.executeQuery(requete);
                //String nom = result.getString(TABLE_USERS_NAME_COLUMN_NAME);
                //int i=0;
                //while (resultSet.next()){
                //result.add(resultSet.get);
                //i++;
                //}
                result = resultSetToArrayList(resultSet);

            } else {
                modification = statement.executeUpdate(requete);
                /*vaut soit le nombre de colonnes resultat ou 0 si il n'y pas de resultat*/
            }
        } catch (SQLException e) {
            /* Gérer les éventuelles erreurs ici */
            e.printStackTrace();
        } finally {
            if (connexion != null) {
                try {
                    /* Fermeture de la connexion */
                    connexion.close();
                } catch (SQLException ignore) {
                    /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }
            }
        }
    }
    public DataBaseLayer(){}
    
    public DataBaseLayer(String requete, BufferedImage img) {
        //Récupération des données SQL
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            /* Gérer les éventuelles erreurs ici. */
            e.printStackTrace();
        }
        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/database_sinovar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "Julie";
        String password = "sinovAr4";
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement pstmt = null;
        ByteArrayInputStream imageBlobStream = getBlobByImage(img);
 
        try {
            pstmt = 
                (PreparedStatement) connexion.prepareStatement(requete);
            pstmt.setBinaryStream(1,imageBlobStream,imageBlobStream.available());
//          execute statement
            pstmt.executeUpdate();
            System.out.println("generic part added in the DB");
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\n DB Error :can not perform query : \"" + requete + "\"");
        }
    
    }
    
    public BufferedImage getBuffImg(String requete) {
        //Récupération des données SQL
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            /* Gérer les éventuelles erreurs ici. */
            e.printStackTrace();
        }
        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/database_sinovar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "Julie";
        String password = "sinovAr4";
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        try {
            statement = connexion.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BufferedImage buffImg = null ;
        try {
            /* Création de l'objet gérant les requêtes */
 /* Exécution d'une requête de lecture */
            if (requete.toUpperCase().startsWith("SELECT")) {
                /*selon si la requête est une lecture ou une modification*/
                ResultSet resultSet = statement.executeQuery(requete);
                if (resultSet.next()) {
                    Blob blob = resultSet.getBlob("image");
                    // materialize BLOB onto client
                    ByteArrayInputStream bais = new ByteArrayInputStream(blob.getBytes(1, (int) blob.length()));
                    try {
                        buffImg = ImageIO.read(bais);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            } else {
                modification = statement.executeUpdate(requete);
                /*vaut soit le nombre de colonnes resultat ou 0 si il n'y pas de resultat*/
            }
        } catch (SQLException e) {
            /* Gérer les éventuelles erreurs ici */
            e.printStackTrace();
        } finally {
            if (connexion != null) {
                try {
                    /* Fermeture de la connexion */
                    connexion.close();
                } catch (SQLException ignore) {
                    /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }
            }
        }
        return buffImg;
    }
    private ByteArrayInputStream getBlobByImage(BufferedImage buff) {        
            byte[] imageBytes;
            if(buff != null) {
                 BufferedImage bImage = (BufferedImage)buff;
                 ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
                 try {
                     ImageIO.write(bImage, "jpeg", baos);
                 } catch (IOException e) {
                     throw new IllegalStateException(e.toString());
                 }
                 imageBytes = baos.toByteArray();    
            }
            else {
             imageBytes = new byte[0];
             System.out.println("PCD error : the buffered image is null");
            }
            ByteArrayInputStream inStream = new ByteArrayInputStream(imageBytes);
            return inStream;        
    }
    /**
     * @return the resultat
     */
    public ArrayList<ArrayList<String>> getResult() {
        return result;
    }

    /**
     * @return the modification
     */
    public int getModification() {
        return modification;
    }

    ArrayList<ArrayList<String>> resultSetToArrayList(ResultSet row) throws SQLException {
        ResultSetMetaData meta = row.getMetaData();
        int length = meta.getColumnCount();
        ArrayList<ArrayList<String>> model = new ArrayList<>();
        ArrayList<String> columnLabels = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            columnLabels.add(meta.getColumnLabel(i + 1));
        }
        model.add(columnLabels);

        while (row.next()) {
            ArrayList<String> rowList = new ArrayList<>();
            for (int i = 0; i < length; ++i) {
                rowList.add(row.getString(i + 1));
            }
            model.add(rowList);
        }
        return model;
    }

    /**
     * @return the connexion
     */
    public Connection getConnexion() {
        return connexion;
    }

    /**
     * @return the buffImg
     */

}
