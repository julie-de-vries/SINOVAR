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


import java.sql.*;

public class DataBaseLayer {
    private final static String TABLE_USERS_NAME_COLUMN_NAME = "nom";
    private ResultSet result;
   private int modification;
   private Connection connexion;

    DataBaseLayer(String requete){
       //Récupération des données SQL
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            /* Gérer les éventuelles erreurs ici. */
            e.printStackTrace();
        }
        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/sinovar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        connexion = null;
       try {
           connexion = DriverManager.getConnection( url ,"Julie","sinovAr4");
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
            if (requete.startsWith("SELECT")){/*selon si la requête est une lecture ou une modification*/
                result = statement.executeQuery( requete );
                String nom = result.getString(TABLE_USERS_NAME_COLUMN_NAME);
                System.out.println(result);
            }
            else{
                modification = statement.executeUpdate ( requete ); 
                /*vaut soit le nombre de colonnes resultat ou 0 si il n'y pas de resultat*/ 
            }
        } catch ( SQLException e ) {
            /* Gérer les éventuelles erreurs ici */
            System.out.println("pas de connexion");
            e.printStackTrace();
        } finally {
            if ( connexion != null )
                try {
                    /* Fermeture de la connexion */
                    connexion.close();
                } catch ( SQLException ignore ) {
                    /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }
        }
   }

    /**
     * @return the resultat
     */
    public ResultSet getResult() {
        return result;
    }

    /**
     * @return the modification
     */
    public int getModification() {
        return modification;
    }

    /**
     * @return the connexion
     */
    public Connection getConnexion() {
        return connexion;
    }
    
    
}