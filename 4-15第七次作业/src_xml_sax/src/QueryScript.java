import java.util.*;
import java.util.function.*;

public class QueryScript implements Comparator<DataModel>, Predicate<DataModel>
{
	public String name_contains = "";
	public String director_contains = "";
	public String vocal_contains = "";
	public String intro_contains = "";
	public int series_geq=0;
	public int series_leq=999;
	public float rating_geq=0;
	public float rating_leq=10;
	
	public int name_r = 0;
	public int director_r = 0;
	public int vocal_r = 0;
	public int intro_r = 0;
	public int series_r = 0;
	public int rating_r = 0;
	
	public int compare(DataModel a, DataModel b) 
	{
		int v = 0;
		if(a.name.compareTo(b.name)>0)
		{
			v += name_r;
		}
		else if(a.name.compareTo(b.name)<0)
		{
			v -= name_r;
		}
		if(a.director.compareTo(b.director)>0)
		{
			v += director_r;
		}
		else if(a.director.compareTo(b.director)<0)
		{
			v -= director_r;
		}
		if(a.vocal.compareTo(b.vocal)>0)
		{
			v += vocal_r;
		}
		else if(a.vocal.compareTo(b.vocal)<0)
		{
			v -= vocal_r;
		}
		if(a.intro.compareTo(b.intro)>0)
		{
			v += intro_r;
		}
		else if(a.intro.compareTo(b.intro)<0)
		{
			v -= intro_r;
		}
		if(a.series > b.series)
		{
			v += series_r;
		}
		else if(a.series < b.series)
		{
			v -= series_r;
		}
		if(a.rating > b.rating)
		{
			v += rating_r;
		}
		else if(a.rating < b.rating)
		{
			v -= rating_r;
		}
		System.out.println(a.name + ", "+ b.name + ": " + v + "\n");
		return v;
	}
	public boolean test(DataModel t) 

	{
		if(t.name.contains(name_contains))
		{
			if(t.director.contains(director_contains))
			{
				if(t.vocal.contains(vocal_contains))
				{
					if(t.intro.contains(intro_contains))
					{
						if(t.series >= series_geq && t.series <= series_leq)
						{
							if(t.rating >= rating_geq && t.rating <= rating_leq)
							{
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
}
