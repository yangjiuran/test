package com.yjr.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 用邻接矩阵表示图
 *
 * @author yangjiuran
 * @Date 2020/12/24
 */
public class GraphTest {
    private List<String> vertexList; //用于装顶点元素
    private int[][] edges; //用来装邻接矩阵
    private int edgeCounts; //统计 边 数量
    private boolean[] isVistied;

    public static void main(String[] args) {
        String[] arr = {"A", "B", "C", "D", "E"};
        GraphTest graph = new GraphTest(arr.length);
        for (int i = 0; i < arr.length; i++) {
            graph.insertVertex(arr[i]);
        }
        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);

        graph.listEdges();
        graph.dfs();
    }

    public GraphTest(int n) {
        vertexList = new ArrayList<>();
        edges = new int[n][n];
        edgeCounts = 0;
        isVistied = new boolean[n];
    }

    /**
     * 获取相邻节点
     *
     * @param n
     * @return
     */
    public int getFirstAdjoin(int n) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[n][i] != 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param v1 当前节点的值
     * @param v2 当前节点相邻节点的值
     * @return
     */
    public int getNextAdjoin(int v1,int v2){
        for (int i = v2+1; i < vertexList.size(); i++) {
            if(edges[v1][v2]!=0){
                return i;
            }
        }
        return -1;
    }
    public void dfs(boolean[] isVistied ,int i){
        System.out.print(getVertex(i)+"->");
        isVistied[i]=true;
        int firstAdjoin = getFirstAdjoin(i);
        while (firstAdjoin!=-1){
            if(!isVistied[firstAdjoin]){
                dfs(isVistied,firstAdjoin);
            }
            firstAdjoin=getNextAdjoin(i,firstAdjoin);
        }
    }

    private void dfs(){
        for (int i = 0; i < vertexList.size(); i++) {
            if(!isVistied[i]){
                dfs(isVistied,i);
            }
        }
    }

    public void listEdges() {
        for (int[] edge : edges) {
            for (int i : edge) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /**
     * 插入顶点
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public int getVertexCount() {
        return vertexList.size();
    }

    /**
     * 获取顶点
     *
     * @param n
     * @return
     */
    public String getVertex(int n) {
        return vertexList.get(n);
    }

    /**
     * 插入边
     *
     * @param v1     顶点1对应的索引
     * @param v2
     * @param weight 权重 0 表示不存在边，1表示存在边
     */
    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgeCounts++;
    }

}
