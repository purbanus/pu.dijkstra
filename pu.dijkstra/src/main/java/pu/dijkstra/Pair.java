package pu.dijkstra;

import java.util.function.Function;

import lombok.Data;

/**
 * Created by Ken Kousen on 11/9/16.
 */

@Data //(staticConstructor="of")
public class Pair<F, S>
{
private F first;
private S second;

public Pair( F aFirst, S aSecond )
{
	first = aFirst;
	second = aSecond;
}
public Pair<S, F> reverse()
{
	return new Pair<>( second, first );
}
public <R, U> Pair<R, U> transform( Function<F, R> xfirst, Function<S, U> xsecond )
{
	return new Pair<R, U>( xfirst.apply( first ), xsecond.apply( second ) );
}
}
