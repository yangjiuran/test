package com.yjr.dataStructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
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
        System.out.println();
        graph.bfs();
    }

    public GraphTest(int n) {
        vertexList = new ArrayList<>();
        edges = new int[n][n];
        edgeCounts = 0;

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
     * @param v2 当前节点 前一个 相邻节点的值
     * @return
     */
    public int getNextAdjoin(int v1,int v2){
        for (int i = v2+1; i < vertexList.size(); i++) {
            if(edges[v1][i]!=0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历 访问第一个节点v的第一个相邻节点w，在以相邻节点w为v访问v的相邻节点
     * @param isVistied 存储节点是否有访问过
     * @param i 节点索引
     *      思路分析：
     *             1.访问当前节点 i 并将isVistied[i]=true 表示当前节点已经被访问过
     *             2.获取当前节点的第一个相邻节点 w
     *             3.判断 w 是否存在（w!=-1）再判断 w  节点是否可未被访问，如果 w  可以访问重复步骤1 2 即递归当前方法
     *             4.获取 i 从 w 开始的下一个邻接节点，将w= 下一个邻接节点，重复步骤 3
     */
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


    private void bfs(){
        isVistied = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if(!isVistied[i]){
                bfs(isVistied,i);
            }
        }
    }
    /**
     * 广度优先遍历访 问第一个节点的所有节点后再访问下一个节点以及他的所有节点
     */
    private void bfs(boolean[] isVistied ,int i){
        System.out.print(getVertex(i)+"->");
        LinkedList<Integer> queue = new LinkedList<>();
        isVistied[i]=true;
        queue.addLast(i);
        int u;//表示当前节点
        int w;//表示相邻接点
        while(!queue.isEmpty()){
            u=queue.removeFirst();
            w=getFirstAdjoin(u);
            while (w!=-1){
                if(!isVistied[w]){
                    System.out.print(getVertex(w)+"->");
                    queue.addLast(w);
                    isVistied[w]=true;
                }
                w=getNextAdjoin(u,w);
            }
        }
    }

    private void dfs(){
        isVistied = new boolean[vertexList.size()];
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
