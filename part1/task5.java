package part1;

import java.util.LinkedList;
import java.util.Queue;
    class Warehouse {
        Queue<String> goodsQueue;
        Warehouse() {
            goodsQueue = new LinkedList<>();
        }

        void storeGoods(String goods) {
            goodsQueue.offer(goods);
        }

        void displayWarehouseQueue() {
            System.out.println("part1.Warehouse Queue:");
            for (String goods : goodsQueue) {
                System.out.println(goods);
            }
            System.out.println();
        }
        void loadGoodsToVehicle() {
            System.out.println("Loading goods onto the delivery vehicle:");
            while (!goodsQueue.isEmpty()) {
                System.out.println("Loaded: " + goodsQueue.poll());
            }
            System.out.println("All goods loaded.");
        }
    }

    public class task5 {
        public static void main(String[] args) {
            Warehouse warehouse = new Warehouse();

            // Storing 10 goods in the warehouse
            for (int i = 1; i <= 10; i++) {
                warehouse.storeGoods("Goods " + i);
            }

            // Displaying the warehouse queue
            warehouse.displayWarehouseQueue();

            // Loading goods onto the delivery vehicle (last in, first out)
            warehouse.loadGoodsToVehicle();
        }
    }