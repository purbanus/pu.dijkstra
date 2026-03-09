package pu.dijkstra.astar_zonder_t;

import lombok.Data;
import lombok.ToString;

@Data
public class Station implements Node
{
private final String id;
private final String name;
@ToString.Exclude
private final double latitude;
@ToString.Exclude
private final double longitude;
}