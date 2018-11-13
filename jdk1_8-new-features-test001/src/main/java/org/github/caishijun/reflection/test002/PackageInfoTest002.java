package org.github.caishijun.reflection.test002;

public class PackageInfoTest002 {

    public static void main(String[] args) {

        Package p = Package.getPackage("java.lang");
        System.out.println(p.getName());        //获取包名

        Package[] ps = Package.getPackages();       //获得所有能够使用的 Package 。
        for(Package p1 : ps){
            System.out.println(p.getName());
        }
    }

}
