package process;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerationAndSortArray extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextArea textArea;
    private JButton generateButton;
    private JButton quickSortButton;
    private JButton bubbleSortButton;
    private JButton heapSortButton;
    private JButton insertionSortButton;
    private JButton selectionSortButton;

    public GenerationAndSortArray() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hello DTS from me");
        setSize(800, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);

        generateButton = new JButton("Tạo mới");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateRandomStringArray();
            }
        });
        panel.add(generateButton);

        selectionSortButton = new JButton("Sắp xếp lựa chọn");
        selectionSortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortUsingSelectionSort();
            }
        });
        panel.add(selectionSortButton);

        quickSortButton = new JButton("Sắp xếp nhanh");
        quickSortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortUsingQuickSort();
            }
        });
        panel.add(quickSortButton);

        bubbleSortButton = new JButton("Sắp xếp nổi bọt");
        bubbleSortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortUsingBubbleSort();
            }
        });
        panel.add(bubbleSortButton);

        heapSortButton = new JButton("Sắp xếp vun đống");
        heapSortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortUsingHeapSort();
            }
        });
        panel.add(heapSortButton);

        insertionSortButton = new JButton("Sắp xếp chèn");
        insertionSortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortUsingInsertionSort();
            }
        });
        panel.add(insertionSortButton);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    // Hàm sinh ngẫu nhiên mảng ký tự gồm 1000 phần tử độ dài từ 1 đến 5
    private void generateRandomStringArray() {
        String[] randomStrings = new String[1000];
        for (int i = 0; i < randomStrings.length; i++) {
            randomStrings[i] = RandomStringUtils.randomAlphabetic(1, 6);
        }
        textArea.setText(String.join("\n", randomStrings));
    }


    // Sắp xếp lựa chọn
    public void sortUsingSelectionSort() {
        if (validateArray(textArea.getText())) {
            return;
        }
        String[] arr = textArea.getText().split("\n");
        selectionSort(arr);
        textArea.setText(String.join("\n", arr));
    }
    private void selectionSort(String[] arr) {
        if (validateArray(textArea.getText())) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            // Tìm phần tử nhỏ nhất chưa được sắp xếp
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j].compareTo(arr[min_idx]) < 0)
                    min_idx = j;

            // Đổi chỗ phần tử nhỏ nhất tìm được với phần tử i
            swap(arr, i, min_idx);
        }

    }

    // Hàm sắp xếp nổi bọt
    public void sortUsingBubbleSort() {
        if (validateArray(textArea.getText())) {
            return;
        }
        String[] arr = textArea.getText().split("\n");
        bubbleSort(arr);
        textArea.setText(String.join("\n", arr));
    }

    private void bubbleSort(String[] arr) {
        if (validateArray(textArea.getText())) {
            return;
        }

        boolean isSwapped = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    // Đánh dấu đã có sự thay đổi
                    isSwapped = true;
                }
            }
        }

        if (!isSwapped) {
            JOptionPane.showMessageDialog(null, "Mảng đã được sắp xếp, không cần sắp xếp lại");
            return;
        }

    }

    // Sắp xếp chèn
    public void sortUsingInsertionSort() {
        if (validateArray(textArea.getText())) {
            return;
        }
        String[] arr = textArea.getText().split("\n");
        insertionSort(arr);
        textArea.setText(String.join("\n", arr));
    }

    private void insertionSort(String[] arr) {

        String key;
        int i, j;
        for (i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Hàm sắp xếp nhanh

    public void sortUsingQuickSort() {
        if (validateArray(textArea.getText())) {
            return;
        }
        String[] arr = textArea.getText().split("\n");
        quickSort(arr, 0, arr.length - 1);
        textArea.setText(String.join("\n", arr));
    }

    private void quickSort(String arr[], int left, int right) {

        if (left < right) {
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }

    }

    private int partition(String arr[], int left, int right) {
        String target = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j].compareTo(target) <= 0) {
                i += 1;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);

        return i + 1;
    }

    // Sắp xếp vun đống

    public void sortUsingHeapSort() {
        if (validateArray(textArea.getText())) {
            return;
        }
        String[] arr = textArea.getText().split("\n");
        heapSort(arr, arr.length);
        textArea.setText(String.join("\n", arr));
    }

    private void heapSort(String[] arr, int n) {
        // Xây dựng lên một đống
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // Thực hiện sắp xếp
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);

            // Sau khi đặt ví trí gốc có giá trị lớn nhất vào cuối mảng, để thoả mãn tính chất đống, phải vun lại
            heapify(arr, i, 0);
        }
    }

    private void heapify(String[] arr, int n, int i) {

        // Khởi tạo largest là một gốc
        int largest = i;
        // Nhánh con bên trái
        int left = 2 * i + 1;
        // Nhánh con bên phải
        int right = 2 * i + 2;

        // Nếu nhánh con bên trái lớn hơn gốc vừa khởi tạo
        if (left < n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }

        // Nếu nhánh con bên phải lớn hơn gốc vừa khởi tạo
        if (right < n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }

        // Đổi lại chỗ và tiếp tục vun đống
        // Nếu largest không phải là gốc đã khởi tạo mà thuộc vào 1 trong 2 điều kiện ở trên
        if (largest != i) {
            swap(arr, i, largest);

            // Dùng đệ quy gọi lại hàm để tiếp tục vun đống
            heapify(arr, n, largest);
        }

    }

    // Validate mảng
    private boolean validateArray(String request) {
        if (StringUtils.isBlank(request)) {
            textArea.setText("Mảng không tồn tại phần tử nào để sắp xếp");
            return true;
        }
        return false;
    }

    private void swap(String[] arr, int i, int j) {
        String intermediateVar = arr[i];
        arr[i] = arr[j];
        arr[j] = intermediateVar;
    }

}
