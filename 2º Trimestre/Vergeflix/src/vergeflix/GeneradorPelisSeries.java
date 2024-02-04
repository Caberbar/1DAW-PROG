package vergeflix;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Esta clase abstracta se encargará de generar elementos al catálogo. 
 * Es una versión inicial que he creado sobre el trabajo de Vergeflix.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class GeneradorPelisSeries {

    /**
     * Construye objetos para catalogo.
     * Se encargará de contruir objetos Pelicula, Serie, Temporada y Capitulos
     * para el catalogo.
     * @return Devolverá un ArrayList con los objetos ya creados.
     */
    public static ArrayList<Media> generarPelisSeries() {
        ArrayList<Media> catalogo = new ArrayList<>();
        
        
        catalogo.add(new Pelicula("La La Land",0,LocalDate.now(),true,"Damien Chazelle","Ryan Gosling",128,Tematica.COMEDIA));

        catalogo.add(new Pelicula("Inception",13,LocalDate.now(),true,"Christopher Nolan","Leonardo DiCaprio",148,Tematica.CIENCIA_FICCION));
        
        catalogo.add(new Pelicula("The Shawshank Redemption",16,LocalDate.now(),true,"Frank Darabont","Tim Robbins",142,Tematica.DRAMA));
        
        catalogo.add(new Pelicula("The Godfather",18,LocalDate.now(),true,"Francis Ford Coppola","Marlon Brando",175,Tematica.SUSPENSE));

        catalogo.add(new Pelicula("The Dark Knight",13,LocalDate.now(),true,"Christopher Nolan","Christian Bale",152,Tematica.CIENCIA_FICCION));
        
        catalogo.add(new Pelicula("Titanic",13,LocalDate.now(),true,"James Cameron","Leonardo DiCaprio",194,Tematica.DRAMA));
        
        catalogo.add(new Pelicula("The Godfather",17,LocalDate.now(),true,"Francis Ford Coppola","Marlon Brando",175,Tematica.DRAMA));
        
        catalogo.add(new Pelicula("Forrest Gump",13,LocalDate.now(),true,"Robert Zemeckis","Tom Hanks",142,Tematica.COMEDIA));
        
        catalogo.add(new Pelicula("The Matrix",17,LocalDate.now(),true,"Lana Wachowski","Keanu Reeves",136,Tematica.CIENCIA_FICCION));
        
        catalogo.add(new Pelicula("The Silence of the Lambs",17,LocalDate.now(),true,"Jonathan Demme","Anthony Hopkins",118,Tematica.DRAMA));
        
        catalogo.add(new Pelicula("Pulp Fiction",17,LocalDate.now(),true,"Quentin Tarantino","John Travolta",154,Tematica.COMEDIA));
        
        catalogo.add(new Pelicula("Star Wars: Episode IV - A New Hope",10,LocalDate.now(),true,"George Lucas","Harrison Ford",121,Tematica.CIENCIA_FICCION));
        
        catalogo.add(new Pelicula("The Lord of the Rings: The Fellowship of the Ring",13,LocalDate.now(),true,"Peter Jackson","Elijah Wood",178,Tematica.FANTASIA));
        
        catalogo.add(new Pelicula("Jurassic Park",13,LocalDate.now(),true,"Steven Spielberg","Sam Neill",127,Tematica.CIENCIA_FICCION));
        
        catalogo.add(new Pelicula("Goodfellas",17,LocalDate.now(),true,"Martin Scorsese","Robert De Niro",146,Tematica.DRAMA));
        
        catalogo.add(new Pelicula("The Exorcist",17,LocalDate.now(),true,"William Friedkin","Ellen Burstyn",122,Tematica.TERROR));
        
        catalogo.add(new Pelicula("Jaws",10,LocalDate.now(),true,"Steven Spielberg","Roy Scheider",124,Tematica.TERROR));
        
        catalogo.add(new Pelicula("The Terminator",17,LocalDate.now(),true,"James Cameron","Arnold Schwarzenegger",107,Tematica.CIENCIA_FICCION));
        
        catalogo.add(new Pelicula("Die Hard",17,LocalDate.now(),true,"John McTiernan","Bruce Willis",131,Tematica.SUSPENSE));
        
        catalogo.add(new Pelicula("The Social Network",13,LocalDate.now(),true,"David Fincher","Andrew Garfield",120,Tematica.DRAMA));
        
        catalogo.add(new Pelicula("Willy Wonka & the Chocolate Factory",0,LocalDate.now(),true,"Mel Stuart","Gene Wilder",100,Tematica.FANTASIA));
        
        catalogo.add(new Pelicula("Mary Poppins",0,LocalDate.now(),true,"Robert Stevenson","Julie Andrews",139,Tematica.COMEDIA));
        
        catalogo.add(new Pelicula("The Sound of Music",0,LocalDate.now(),true,"Robert Wise","Christopher Plummer",172,Tematica.DRAMA));
        
        catalogo.add(new Pelicula("E.T. the Extra-Terrestrial",0,LocalDate.now(),true,"Steven Spielberg","Henry Thomas",115,Tematica.CIENCIA_FICCION));
        
        catalogo.add(new Pelicula("The Princess Diaries",0,LocalDate.now(),true,"Garry Marshall","Anne Hathaway",115,Tematica.DRAMA));
        
        catalogo.add(new Pelicula("The Aristocats",0,LocalDate.now(),true,"Wolfgang Reitherman","Phil Harris",78,Tematica.COMEDIA));
        
        catalogo.add(new Pelicula("Cinderella",0,LocalDate.now(),true,"Clyde Geronimi","Ilene Woods",120,Tematica.FANTASIA));
        
        catalogo.add(new Pelicula("The Shining",17,LocalDate.now(),true,"Stanley Kubrick","Jack Nicholson",146,Tematica.TERROR));
        
        catalogo.add(new Pelicula("A Quiet Place",13,LocalDate.now(),true,"John Krasinski","Emily Blunt",90,Tematica.TERROR));
        
        catalogo.add(new Pelicula("Hereditary",17,LocalDate.now(),true,"Ari Aster","Toni Collette",127,Tematica.TERROR));

        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        Serie JuegoTronos = new Serie("Games of Thrones", 13, LocalDate.now(), true,LocalDate.now());
        
        Temporada JuegoTronosT1 = (new Temporada(LocalDate.now()));
        
        JuegoTronosT1.añadirCapitulo(LocalDate.now(),"Winter Is Coming");
        JuegoTronosT1.añadirCapitulo(LocalDate.now(), "Winter Is Coming");
        JuegoTronosT1.añadirCapitulo(LocalDate.now(), "The Kingsroad");
        JuegoTronosT1.añadirCapitulo(LocalDate.now(), "Lord Snow");
        JuegoTronosT1.añadirCapitulo(LocalDate.now(), "Cripples, Bastards, and Broken Things");
        JuegoTronosT1.añadirCapitulo(LocalDate.now(), "The Wolf and the Lion");
        JuegoTronosT1.añadirCapitulo(LocalDate.now(), "A Golden Crown");
        JuegoTronosT1.añadirCapitulo(LocalDate.now(), "You Win or You Die");
        JuegoTronosT1.añadirCapitulo(LocalDate.now(), "The Pointy End");
        JuegoTronosT1.añadirCapitulo(LocalDate.now(), "Baelor");
        JuegoTronosT1.añadirCapitulo(LocalDate.now(), "Fire and Blood");
                
        JuegoTronos.añadirTemporada(JuegoTronosT1);  
        
        Temporada JuegoTronosT2 = (new Temporada(LocalDate.now()));

        JuegoTronosT2.añadirCapitulo(LocalDate.now(), "The North Remembers");
        JuegoTronosT2.añadirCapitulo(LocalDate.now(), "The Night Lands");
        JuegoTronosT2.añadirCapitulo(LocalDate.now(), "What Is Dead May Never Die");
        JuegoTronosT2.añadirCapitulo(LocalDate.now(), "Garden of Bones");
        JuegoTronosT2.añadirCapitulo(LocalDate.now(), "The Ghost of Harrenhal");
        JuegoTronosT2.añadirCapitulo(LocalDate.now(), "The Old Gods and the New");
        JuegoTronosT2.añadirCapitulo(LocalDate.now(), "A Man Without Honor");
        JuegoTronosT2.añadirCapitulo(LocalDate.now(), "The Prince of Winterfell");
        JuegoTronosT2.añadirCapitulo(LocalDate.now(), "Blackwater");
        JuegoTronosT2.añadirCapitulo(LocalDate.now(), "Valar Morghulis");
        
        JuegoTronos.añadirTemporada(JuegoTronosT2); 
        
        Temporada JuegoTronosT3 = (new Temporada(LocalDate.now()));

        JuegoTronosT3.añadirCapitulo(LocalDate.now(), "Valar Dohaeris");
        JuegoTronosT3.añadirCapitulo(LocalDate.now(), "Dark Wings, Dark Wordss");
        JuegoTronosT3.añadirCapitulo(LocalDate.now(), "Walk of Punishment");
        JuegoTronosT3.añadirCapitulo(LocalDate.now(), "And Now His Watch is Ended");
        JuegoTronosT3.añadirCapitulo(LocalDate.now(), "Kissed by Fire");
        JuegoTronosT3.añadirCapitulo(LocalDate.now(), "The Climb");
        JuegoTronosT3.añadirCapitulo(LocalDate.now(), "The Bear and the Maiden Fair");
        JuegoTronosT3.añadirCapitulo(LocalDate.now(), "Second Sons");
        JuegoTronosT3.añadirCapitulo(LocalDate.now(), "The Rains of Castamere");
        JuegoTronosT3.añadirCapitulo(LocalDate.now(), "Mhysa");
        
        JuegoTronos.añadirTemporada(JuegoTronosT3); 
        
        Temporada JuegoTronosT4 = (new Temporada(LocalDate.now()));

        JuegoTronosT4.añadirCapitulo(LocalDate.now(), "Two Swords");
        JuegoTronosT4.añadirCapitulo(LocalDate.now(), "The Lion and the Rose");
        JuegoTronosT4.añadirCapitulo(LocalDate.now(), "Breaker of Chains");
        JuegoTronosT4.añadirCapitulo(LocalDate.now(), "Oathkeeper");
        JuegoTronosT4.añadirCapitulo(LocalDate.now(), "First of His Name");
        JuegoTronosT4.añadirCapitulo(LocalDate.now(), "The Laws of Gods and Men");
        JuegoTronosT4.añadirCapitulo(LocalDate.now(), "Mockingbird");
        JuegoTronosT4.añadirCapitulo(LocalDate.now(), "The Mountain and the Viper");
        JuegoTronosT4.añadirCapitulo(LocalDate.now(), "The Watchers on the Wall");
        JuegoTronosT4.añadirCapitulo(LocalDate.now(), "The Children");
        
        JuegoTronos.añadirTemporada(JuegoTronosT4); 
        
        Temporada JuegoTronosT5 = (new Temporada(LocalDate.now()));

        JuegoTronosT5.añadirCapitulo(LocalDate.now(), "The Wars to Come");
        JuegoTronosT5.añadirCapitulo(LocalDate.now(), "The House of Black and White");
        JuegoTronosT5.añadirCapitulo(LocalDate.now(), "High Sparrow");
        JuegoTronosT5.añadirCapitulo(LocalDate.now(), "Sons of the Harpy");
        JuegoTronosT5.añadirCapitulo(LocalDate.now(), "Kill the Boy");
        JuegoTronosT5.añadirCapitulo(LocalDate.now(), "Unbowed, Unbent, Unbroken");
        JuegoTronosT5.añadirCapitulo(LocalDate.now(), "The Gift");
        JuegoTronosT5.añadirCapitulo(LocalDate.now(), "Hardhome");
        JuegoTronosT5.añadirCapitulo(LocalDate.now(), "The Dance of Dragons");
        JuegoTronosT5.añadirCapitulo(LocalDate.now(), "Mother's Mercy");
        
        JuegoTronos.añadirTemporada(JuegoTronosT5); 
        
        Temporada JuegoTronosT6 = (new Temporada(LocalDate.now()));

        JuegoTronosT6.añadirCapitulo(LocalDate.now(), "The Red Woman");
        JuegoTronosT6.añadirCapitulo(LocalDate.now(), "Home");
        JuegoTronosT6.añadirCapitulo(LocalDate.now(), "Oathbreaker");
        JuegoTronosT6.añadirCapitulo(LocalDate.now(), "Book of the Stranger");
        JuegoTronosT6.añadirCapitulo(LocalDate.now(), "The Door");
        JuegoTronosT6.añadirCapitulo(LocalDate.now(), "Blood of My Blood");
        JuegoTronosT6.añadirCapitulo(LocalDate.now(), "The Broken Man");
        JuegoTronosT6.añadirCapitulo(LocalDate.now(), "No One");
        JuegoTronosT6.añadirCapitulo(LocalDate.now(), "Battle of the Bastards");
        JuegoTronosT6.añadirCapitulo(LocalDate.now(), "The Winds of Winter");
        
        JuegoTronos.añadirTemporada(JuegoTronosT6); 
        
        Temporada JuegoTronosT7 = (new Temporada(LocalDate.now()));

        JuegoTronosT7.añadirCapitulo(LocalDate.now(), "Dragonstone");
        JuegoTronosT7.añadirCapitulo(LocalDate.now(), "Stormborn");
        JuegoTronosT7.añadirCapitulo(LocalDate.now(), "The Queen's Justice");
        JuegoTronosT7.añadirCapitulo(LocalDate.now(), "The Spoils of War");
        JuegoTronosT7.añadirCapitulo(LocalDate.now(), "Eastwatch");
        JuegoTronosT7.añadirCapitulo(LocalDate.now(), "Beyond the Wall");
        JuegoTronosT7.añadirCapitulo(LocalDate.now(), "The Dragon and the Wolf");
        
        JuegoTronos.añadirTemporada(JuegoTronosT7); 
        
        Temporada JuegoTronosT8 = (new Temporada(LocalDate.now()));

        JuegoTronosT8.añadirCapitulo(LocalDate.now(), "Winterfell");
        JuegoTronosT8.añadirCapitulo(LocalDate.now(), "A Knight of the Seven Kingdoms");
        JuegoTronosT8.añadirCapitulo(LocalDate.now(), "The Long Night");
        JuegoTronosT8.añadirCapitulo(LocalDate.now(), "The Last of the Starks");
        JuegoTronosT8.añadirCapitulo(LocalDate.now(), "The Bells");
        JuegoTronosT8.añadirCapitulo(LocalDate.now(), "The Iron Throne");
        
        JuegoTronos.añadirTemporada(JuegoTronosT8); 
        
        catalogo.add(JuegoTronos);
        
        
        
        Serie TheSociety = new Serie( "The Society", 18, LocalDate.now(), true,LocalDate.now());

        
        Temporada TheSocietyT1 = (new Temporada(LocalDate.now()));
        
        TheSocietyT1.añadirCapitulo(LocalDate.now(), "What Happened");
        TheSocietyT1.añadirCapitulo(LocalDate.now(), "Our Town");
        TheSocietyT1.añadirCapitulo(LocalDate.now(), "Childhood's End");
        TheSocietyT1.añadirCapitulo(LocalDate.now(), "Drop by Drop");
        TheSocietyT1.añadirCapitulo(LocalDate.now(), "Putting on the Clothes");
        TheSocietyT1.añadirCapitulo(LocalDate.now(), "Like a F-ing God or Something");
        TheSocietyT1.añadirCapitulo(LocalDate.now(), "Allie's Rules");
        TheSocietyT1.añadirCapitulo(LocalDate.now(), "Poison");
        TheSocietyT1.añadirCapitulo(LocalDate.now(), "New Names");
        TheSocietyT1.añadirCapitulo(LocalDate.now(), "How it Happens");

        TheSociety.añadirTemporada(TheSocietyT1);
        catalogo.add(TheSociety);
        
        
        
        Serie Chernobyl = new Serie("Chernobyl", 16, LocalDate.now(), true,LocalDate.now());
        
        Temporada ChernobylT1 = (new Temporada(LocalDate.now()));
        
        ChernobylT1.añadirCapitulo(LocalDate.now(), "1:23:45");
        ChernobylT1.añadirCapitulo(LocalDate.now(), "Please Remain Calm");
        ChernobylT1.añadirCapitulo(LocalDate.now(), "Open Wide, O Earth");
        ChernobylT1.añadirCapitulo(LocalDate.now(), "The Happiness of All Mankind");
        ChernobylT1.añadirCapitulo(LocalDate.now(), "Víchnaya Pámyat");

        Chernobyl.añadirTemporada(ChernobylT1);
        catalogo.add(Chernobyl);
        
        
        Serie Gambitodedama = new Serie("The Queen's Gambit", 13, LocalDate.now(), true,LocalDate.now());
        
        Temporada GambitodedamaT1 = (new Temporada(LocalDate.now()));
        
        GambitodedamaT1.añadirCapitulo(LocalDate.now(), "Openings");
        GambitodedamaT1.añadirCapitulo(LocalDate.now(), "Exchanges");
        GambitodedamaT1.añadirCapitulo(LocalDate.now(), "Doubled Pawns");
        GambitodedamaT1.añadirCapitulo(LocalDate.now(), "Middle Game");
        GambitodedamaT1.añadirCapitulo(LocalDate.now(), "Fork");
        GambitodedamaT1.añadirCapitulo(LocalDate.now(), "Adjournment");
        GambitodedamaT1.añadirCapitulo(LocalDate.now(), "End Game");

        Gambitodedama.añadirTemporada(GambitodedamaT1);
        catalogo.add(Gambitodedama);
        
        
        
        Serie Farina = new Serie("Fariña", 18, LocalDate.now(), true,LocalDate.now());

        Temporada FarinaT1 = (new Temporada(LocalDate.now()));
        
        FarinaT1.añadirCapitulo(LocalDate.now(), "1981");
        FarinaT1.añadirCapitulo(LocalDate.now(), "1982");
        FarinaT1.añadirCapitulo(LocalDate.now(), "1983");
        FarinaT1.añadirCapitulo(LocalDate.now(), "1984");
        FarinaT1.añadirCapitulo(LocalDate.now(), "1985");
        FarinaT1.añadirCapitulo(LocalDate.now(), "1986");
        FarinaT1.añadirCapitulo(LocalDate.now(), "1987");
        FarinaT1.añadirCapitulo(LocalDate.now(), "1988");
        FarinaT1.añadirCapitulo(LocalDate.now(), "1989/1990");
        FarinaT1.añadirCapitulo(LocalDate.now(), "1990");

        Farina.añadirTemporada(FarinaT1);
        catalogo.add(Farina);
        
        
        
        Serie ShadowandBone = new Serie("Shadow and Bone", 16, LocalDate.now(), true,LocalDate.now());
        
        Temporada ShadowandBoneT1 = (new Temporada(LocalDate.now()));
        
        ShadowandBoneT1.añadirCapitulo(LocalDate.now(), "A Searing Burst of Light");
        ShadowandBoneT1.añadirCapitulo(LocalDate.now(), "We're All Someone's Monster");
        ShadowandBoneT1.añadirCapitulo(LocalDate.now(), "The making at the Heart of the World");
        ShadowandBoneT1.añadirCapitulo(LocalDate.now(), "Otkazat'sya");
        ShadowandBoneT1.añadirCapitulo(LocalDate.now(), "Show Me Who You Are");
        ShadowandBoneT1.añadirCapitulo(LocalDate.now(), "The Heart Is An Arrow");
        ShadowandBoneT1.añadirCapitulo(LocalDate.now(), "The Unsea");
        ShadowandBoneT1.añadirCapitulo(LocalDate.now(), "No Mourners");

        ShadowandBone.añadirTemporada(ShadowandBoneT1);
        catalogo.add(ShadowandBone);

        

        Serie SpaceForce = new Serie("Space Force", 13, LocalDate.now(), true,LocalDate.now());
        
        Temporada TemporadaSpaceForceT1 = (new Temporada(LocalDate.now()));
        
        TemporadaSpaceForceT1.añadirCapitulo(LocalDate.now(), "The Launch");
        TemporadaSpaceForceT1.añadirCapitulo(LocalDate.now(), "Save Epsilon 6!");
        TemporadaSpaceForceT1.añadirCapitulo(LocalDate.now(), "Mark and Mallory Go to Washington");
        TemporadaSpaceForceT1.añadirCapitulo(LocalDate.now(), "Lunar Habitat");
        TemporadaSpaceForceT1.añadirCapitulo(LocalDate.now(), "Space Flag");
        TemporadaSpaceForceT1.añadirCapitulo(LocalDate.now(), "The Spy");
        TemporadaSpaceForceT1.añadirCapitulo(LocalDate.now(), "Edison Jaymes");
        TemporadaSpaceForceT1.añadirCapitulo(LocalDate.now(), "Conjugal Visit");
        TemporadaSpaceForceT1.añadirCapitulo(LocalDate.now(), "It's Good to Be Back on the Moon");
        TemporadaSpaceForceT1.añadirCapitulo(LocalDate.now(), "Proportionate Response");
        
        SpaceForce.añadirTemporada(TemporadaSpaceForceT1);
        
        Temporada TemporadaSpaceForceT2 = (new Temporada(LocalDate.now()));
        
        TemporadaSpaceForceT2.añadirCapitulo(LocalDate.now(), "The Inquiry");
        TemporadaSpaceForceT2.añadirCapitulo(LocalDate.now(), "Budget Cuts");
        TemporadaSpaceForceT2.añadirCapitulo(LocalDate.now(), "The Chinese Delegation");
        TemporadaSpaceForceT2.añadirCapitulo(LocalDate.now(), "The Europa Project");
        TemporadaSpaceForceT2.añadirCapitulo(LocalDate.now(), "Mad (Buff) Confidence");
        TemporadaSpaceForceT2.añadirCapitulo(LocalDate.now(), "The Doctor's Appointment");
        TemporadaSpaceForceT2.añadirCapitulo(LocalDate.now(), "The Hack");

        SpaceForce.añadirTemporada(TemporadaSpaceForceT2);
        catalogo.add(SpaceForce);
        
        
        return catalogo;
    }
}
