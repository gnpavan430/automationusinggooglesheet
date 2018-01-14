import java.util.ArrayList;
import java.util.regex.*;

class Main
{
    public static void main(String[] args)
    {
        String txt="200 'https://api.klm.com/travel/reservations/ae934a02056bd924e2b3849f4032fe67/' [0.3389 s] '  ";
        String txt1="200 'https://api.klm.com/travel/reservations/ae934a02056bd924e2b3849f4032fe67/push-subscription-preference/' [0.3389 s]";
        ArrayList<String> data=new ArrayList<String>();
        data.add(txt);
        data.add(txt1);

        String re1=".*?";	// Non-greedy match on filler
        String re2="('https:\\/\\/api\\.klm\\.com\\/travel\\/reservations\\/((?:[a-z][a-z]*[0-9]+[a-z0-9]*))\\/')";	// Single Quote String 1

        Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        for(int i=0;i<data.size();i++){
            Matcher m = p.matcher(data.get(i));
            if (m.find())
            {
                String strng1=m.group(1);
                System.out.print("("+strng1.toString()+")"+"\n");
                System.out.println(data.get(i));
            }

        }

    }
}