/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportGraphs_Queues;

/**
 *
 * @author diana
 */
public interface RootedTree<D,W> extends IGraph<D,W> {
  Vertex<D,W> getRoot();
  void add(Edge<D,W> edge);
  }
