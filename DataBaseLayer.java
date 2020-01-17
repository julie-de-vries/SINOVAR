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
   private ResultSet result;
   private int modification;
   
   
   DataBaseLayer(String requete){
       //RÃ©cupÃ©ration des donnÃ©es SQL
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            /* GÃ©rer les Ã©ventuelles erreurs ici. */
        }
        /* Connexion Ã  la base de donnÃ©es */
        String url = "jdbc:mysql://localhost:3306/bdd_sdzee";
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection( url );
            /* CrÃ©ation de l'objet gÃ©rant les requÃªtes */
            Statement statement = connexion.createStatement();
            /* ExÃ©cution d'une requÃªte de lecture */
            if (requete.startsWith("SELECT")){/*selon si la requÃªte est une lecture ou une modification*/
                result = statement.executeQuery( requete );
            }
            else{
                modification = statement.executeUpdate ( requete ); 
                /*vaut soit le nombre de colonnes resultat ou 0 si il n'y pas de resultat*/ 
            }
        } catch ( SQLException e ) {
            /* GÃ©rer les Ã©ventuelles erreurs ici */
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
    
    
}
