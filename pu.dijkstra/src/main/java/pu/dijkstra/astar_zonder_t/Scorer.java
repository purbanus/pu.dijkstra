package pu.dijkstra.astar_zonder_t;

public interface Scorer
{
public abstract double computeCost( Station from, Station to );
}