package www.ot.domain;

/**
 * Hello world!
 *
 */
public class Address 
{
    public static void fo()
    {
        System.out.println( "Address!" );
    }
    
    public  void fo1()
    {
        System.out.println( "Address!" + this.street );
    }
    
    public String street;
    private String zip;
}
