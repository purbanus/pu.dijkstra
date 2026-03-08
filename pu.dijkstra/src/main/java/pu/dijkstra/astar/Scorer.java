package pu.dijkstra.astar;

public interface Scorer<T extends Node>
{
public abstract double computeCost( T from, T to );
}