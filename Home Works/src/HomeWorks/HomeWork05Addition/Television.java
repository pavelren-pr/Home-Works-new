package HomeWork.HomeWork05Addition;

import java.util.Objects;

public class Television {

    // 1. Поля
    private int currentChannel; // Текущий канал
    private int currentVolume;  // Текущая громкость (0-100)
    private String source; // Источник
    private boolean isOn;       // Включен ли телевизор?

    // 2. Конструкторы (для инициализации состояния при создании объекта)
    // Конструктор по умолчанию (без параметров)
    public Television() {
        this.currentChannel = 1; // Начинаем с 1 канала
        this.currentVolume = 20; // Средняя громкость
        this.source = "TV"; // Изначально выбрано кабельное
        this.isOn = false;      // Телевизор выключен при создании
    }

    // Конструктор с параметрами (позволяет задать конкретные значения при создании)
    public Television(String source, int startChannel, int startVolume) {
        this.source = source; // Задаём источник сигнала
        // Используем сеттеры для канала и громкости, чтобы ВОСПОЛЬЗОВАТЬСЯ ИХ ПРОВЕРКАМИ!
        setCurrentChannel(startChannel); // Проверка на допустимость будет внутри setter
        setCurrentVolume(startVolume);   // Проверка на допустимость будет внутри setter
        this.isOn = false;               // Все равно выключаем при создании
    }

    // 3. Геттеры (Getter Methods) - предоставляют доступ к private полям для чтения
    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public String getSource() {
        return source;
    }

    public boolean isOn() {
        return isOn;
    }

    // 4. Сеттеры, предоставляем доступ к private полям для записи
    public void setSource(String source) {
        if (source != null && !source.trim().isEmpty()) { // Проверка: не null и не пустая строка
            this.source = source;
        } else {
            System.out.println("Ошибка: Должен быть выбран источник сигнала.");
        }
    }

    public void setCurrentChannel(int newChannel) {
        if (newChannel > 0) { // Простейшая проверка: канал должен быть положительным
            this.currentChannel = newChannel;
        } else {
            System.out.println("Ошибка: Номер канала должен быть положительным числом. Текущий канал: " + currentChannel);
        }
    }

    public void setCurrentVolume(int newVolume) {
        if (newVolume >= 0 && newVolume <= 100) { // Проверка: громкость в диапазоне 0-100
            this.currentVolume = newVolume;
        } else {
            System.out.println("Ошибка: Громкость должна быть от 0 до 100. Текущая громкость: " + currentVolume);
        }
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Телевизор с источником " + source + " включен.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Телевизор с источником " + source + " выключен.");
    }

    // 5. Другие методы, реализующие поведение телевизора
    public void increaseVolume() {
        if (isOn) { // Можно менять громкость только если ТВ включен
            setCurrentVolume(currentVolume + 1); // Используем сеттер для изменения (там проверка диапазона)
        } else {
            System.out.println("Ошибка: Телевизор выключен. Включите его сначала.");
        }
    }

    public void decreaseVolume() {
        if (isOn) {
            setCurrentVolume(currentVolume - 1); // Используем сеттер
        } else {
            System.out.println("Ошибка: Телевизор выключен. Включите его сначала.");
        }
    }

    public void nextChannel() {
        if (isOn) {
            setCurrentChannel(currentChannel + 1);
        } else {
            System.out.println("Ошибка: Телевизор выключен. Включите его сначала.");
        }
    }

    public void previousChannel() {
        if (isOn && currentChannel > 1) { // Проверяем, чтобы не уйти ниже 1
            setCurrentChannel(currentChannel - 1);
        } else if (isOn) {
            System.out.println("Ошибка: Уже на первом канале.");
        } else {
            System.out.println("Ошибка: Телевизор выключен. Включите его сначала.");
        }
    }

    // 6. Переопределение метода toString()
    @Override
    public String toString() {
        // Формируем понятную строку с информацией о текущем состоянии объекта
        String status = isOn ? "Включен" : "Выключен"; // Тернарный оператор для статуса
        return "Телевизор. Источник сигнала '" + source + "': " +
                "Канал = " + currentChannel +
                ", Громкость = " + currentVolume +
                ", Состояние = " + status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return currentChannel == that.currentChannel && currentVolume == that.currentVolume
                && isOn == that.isOn && Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentChannel, currentVolume, source, isOn);
    }
}
