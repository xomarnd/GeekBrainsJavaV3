Урок 1. Обобщения

1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
3. Большая задача:
Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
Для хранения фруктов внутри коробки можно использовать ArrayList;
Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true – если она равны по весу, false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами). Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
Не забываем про метод добавления фрукта в коробку.


Урок 2. Базы данных

1. Подключиться к БД
2. Создаь таблицу товаров (good_id, good_name, good_price) запрсом из Java пиложения.
3. При запуске приложения очистить таблицу и заполнить 10000 товаров
4. Написать консольное приложение, которое позволяет узнать цену товара по его имени, либо вывести сообщение «Такого товара нет», если товар не обнаружен в базе.
5. Добавить возможность изменения цены товара. Указываем имя товара и новую цену.
6. Вывести товары в заданном ценовом диапазоне.