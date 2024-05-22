# Втора лабораториска вежба по Софтверско инженерство
# Сара Лазаревска 223225
2. ![Untitled Diagram (1)](https://github.com/SaraLazarevska/SI_2024_lab2_223225-/assets/139071135/6f2cce92-a70e-45cb-9f4c-3a6c5a739550)
3.  цикломатската комплексност = број на ребра - број на региони + 2
   број на ребра = 40
   број на јазли = 32
   цикломатската комплексност = 40 - 32 + 2 = 10
4. ![image](https://github.com/SaraLazarevska/SI_2024_lab2_223225-/assets/139071135/e177d5d1-aeaf-4067-9292-231690b52a1a)
5. За условот if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0)== '0') имам 8 тестови. Комбинациите се: T && T && T, T && T && F, T && F && T, T && F && F, F && T && T, F && T && F, F && F && T, F && F && F, T && T && T: Тестови: 1.T && T && T - price>300, discount>0, barcode започнува со 0. 2.T && T && F - price>300, discount>0, barcode не започнува со 0. 3.T && F && T - price>300, discount=0, barcode започнува со 0. 4.T && F && F - price>300, discount=0, barcode не започнува со 0. 5.F && T && T - price<=300, discount>0, barcode започнува со 0. 6.F && T && F - price<=300, discount>0, barcode не започнува со 0. 7.F && F && T - price<=300, discount=0, barcode започнува со 0. 8.F && F && F - price<=300, discount=0, barcode не започнува со
# Објаснување за Unit тестовите
Во првата функцијата testCheckCart_AllBranches() има test cases за сите гранки кои е можно да се поминат во програмата, а во testCheckCart_MultipleCondition() се напишани тестови за сите можни сценарија кои можат да се добијат за условот if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0)== '0').
