/********************************************************** 
 * * * * Complex.java
 * * * * Tangni Wang
 * * * * twang63
 * * * * Programming Assignment 6
 * * * * This program returns some calculations of complex number. 
 * * * ************************************************************/

class Complex{
   //---------------------------------------------------------------------
   // Private Data Fields 
   //--------------------------------------------------------------------------
    private double re;
    private double im;
   
   //--------------------------------------------------------------------------
   // Public Constant Fields 
   //--------------------------------------------------------------------------
    public static final Complex ONE = Complex.valueOf(1,0);
    public static final Complex ZERO = Complex.valueOf(0,0);
    public static final Complex I = Complex.valueOf(0,1);

   //--------------------------------------------------------------------------
   // Constructors 
   //--------------------------------------------------------------------------
    Complex(double a, double b){
        this.re = a;
        this.im = b;
    }

    Complex(double a){
        this.re = a;
        this.im = 0;
    }

    Complex(String s){
      // Fill in this constructor.
      // It should accept expressions like "-2+3i", "2-3i", "3", "5i", etc..
      // Throw a NumberFormatException if s cannot be parsed as Complex.
        double[] part = new double[2];
        String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
        String SGN = "[+-]?";
        String OP =  "\\s*[+-]\\s*";
        String I =   "i";
        String OR =  "|";
        String REAL = SGN+NUM;
        String IMAG = SGN+NUM+"?"+I;
        String COMP = REAL+OR+ IMAG+OR+ REAL+OP+NUM+"?"+I;
        
        if( !s.matches(COMP) ){
         throw new NumberFormatException(
                   "Cannot parse input string \""+s+"\" as Complex");
      }
      s = s.replaceAll("\\s","");     
      if( s.matches(REAL) ){
         part[0] = Double.parseDouble(s);
         part[1] = 0;
      }else if( s.matches(SGN+I) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I, "1.0" ) );
      }else if( s.matches(IMAG) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I , "" ) );
      }else if( s.matches(REAL+OP+I) ){
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
      }else{   //  s.matches(REAL+OP+NUM+I) 
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
      }this.re = part[0]; this.im = part[1];
    }
    

   //---------------------------------------------------------------------------
   // Public methods 
   //---------------------------------------------------------------------------
    
   // Complex arithmetic -------------------------------------------------------

   // copy()
   // Return a new Complex equal to this Complex
    Complex copy(){
      return new Complex(re, im);
    }
   
   // add()
   // Return a new Complex representing the sum this plus z.
    Complex add(Complex z){
      double re1,re2,im1,im2;
      re1 = this.re;
      im1 = this.im;
      re2 = z.re;
      im2 = z.im;
      
      return new Complex(re1+re2, im1+im2);      
    }
   
   // negate()
   // Return a new Complex representing the negative of this.
    Complex negate(){
      return new Complex(-re, -im);
    }

   // sub()
   // Return a new Complex representing the difference this minus z.
    Complex sub(Complex z){
      double re1,re2,im1,im2;
      re1 = this.re;
      im1 = this.im;
      re2 = z.re;
      im2 = z.im;
      
      return new Complex(re1-re2, im1-im2);
    }

   // mult()
   // Return a new Complex representing the product this times z.
    Complex mult(Complex z){
      double re1, im1, re2, im2, m1, m2, m3, m4;
      re1 = this.re;
      im1 = this.im;
      re2 = z.re;
      im2 = z.im;
      
      m1 = re1 *re2;
      m2 = re1 *im2;
      m3 = re2 *im1;
      m4 = im1 *im2;
      
      return new Complex(m1-m4, m2+m3);
    }

   // recip()
   // Return a new Complex representing the reciprocal of this.
   // Throw an ArithmeticException with appropriate message if 
   // this.equals(Complex.ZERO).
    Complex recip() throws ArithmeticException {
      double d;
      if (re == 0 && im == 0) throw new ArithmeticException("Can't divide by zero");
      d = Math.pow(re, 2) + Math.pow(im,2);
      return new Complex(re/d, -im/d);
    }

   // div()
   // Return a new Complex representing the quotient of this by z.
   // Throw an ArithmeticException with appropriate message if 
   // z.equals(Complex.ZERO).
    Complex div(Complex z) throws ArithmeticException{
        double a, b, c, d, n1,n2, d1;
        a = z.re;
        b = z.im;
        c = this.re;
        d = this.im;

        if (a==0 && b == 0) throw new ArithmeticException("Can't divide by zero");
        
        n1 = c* a + d* b;
        d1 = Math.pow(a, 2)+Math.pow(b, 2);
        n2 = d* a - c* b;
        
        return new Complex(n1/d1, n2/d1);
    }

   // conj()
   // Return a new Complex representing the conjugate of this Complex.
    Complex conj(){
      return new Complex(re, -im);
    }
   
   // Re()
   // Return the real part of this.
    double Re(){
        return re;
    }

   // Im()
   // Return the imaginary part of this.
    double Im(){
        return im;
    }

   // abs()
   // Return the modulus of this Complex, i.e. the distance between 
   // points (0, 0) and (re, im).
    double abs(){
      return (Math.sqrt(Math.pow(re, 2) + Math.pow(im,2)));
    }

   // arg()
   // Return the argument of this Complex, i.e. the angle this Complex
   // makes with positive real axis.
    double arg(){
        return Math.atan2(im, re);
    }

   // Other functions ---------------------------------------------------------
   
   // toString()
   // Return a String representation of this Complex.
   // The String returned will be readable by the constructor Complex(String s)
    public String toString(){
        if(this.re == 0) return (Double.toString(this.im)+"i");
        else if(this.im == 0) return Double.toString(this.re);
        else if(this.im < 0) return (Double.toString(this.re)+Double.toString(this.im)+"i");
        else return (Double.toString(this.re)+"+" + Double.toString(this.im)+"i");
    }

   // equals()
   // Return true iff this and obj have the same real and imaginary parts.
    public boolean equals(Object obj){
      Complex c;
      boolean eq = false;
      if(obj instanceof Complex){
          c = (Complex) obj;
          eq = this.re == c.re&& this.im == c.im;
          
      }return eq;
    }

   // valueOf()
   // Return a new Complex with real part a and imaginary part b.
    static Complex valueOf(double a, double b){
      return new Complex(a, b);
    }

   // valueOf()
   // Return a new Complex with real part a and imaginary part 0.
    static Complex valueOf(double a){
      return new Complex(a,0);
    }

   // valueOf()
   // Return a new Complex constructed from s.
    static Complex valueOf(String s){
      return new Complex(s);
    }

}
