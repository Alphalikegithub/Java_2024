package com.cskaoyan;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // 替换为实际值
        double Longitude = 110.909850496;
        double Latitude = 19.575067915;
        double Height = 90.520;
        double azimuth = 34.3;

        // 创建 Compute_to_dji 实例
        Compute_to_dji compute = new Compute_to_dji();

        // 调用 Compute 方法
        compute.Compute(Longitude, Latitude, Height, azimuth);
    }

    public static class Compute_to_dji{
        //static double uavLat = 19.574089299; // 无人机的纬度
        //static double uavLon = 110.911193274; // 无人机的经度
        //static double heading = 270+85.2; // 航向角，以度为单位
        private static final double EARTH_RADIUS = 6371.393 * 1000;
        private static final double distance= Math.sqrt(22.5 * 22.5 + 38.0 * 38.0);
        //        private static final double distance = 0.5; // 预设无人机中心点到板子中心点距离向量的长度，以米为单位
        private static final double height = 0.38; // 预设无人机中心点到板子中心点高度向量的长度，以米为单位

        public void Compute(double Longitude, double Latitude,double Height,double azimuth){
            // 已知点的经纬度和高程
            double boardAzimuth = 270 + azimuth;
            //double boardAzimuth = azimuth;
            double headingRad = Math.toRadians(boardAzimuth);
            double boardLat = Latitude + (distance / EARTH_RADIUS) * Math.cos(headingRad) * (180 / Math.PI);
            double boardLon = Longitude + distance*Math.sin(headingRad)/(EARTH_RADIUS*Math.cos(boardLat*Math.PI/180)*2*Math.PI/360);
            double boardheight = Height - height;

            System.out.printf("经度: %s°\n纬度: %s°\n高程: %s米\n",boardLon, boardLat, boardheight);
        }
    }
}


