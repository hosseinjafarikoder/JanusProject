package com.example.janustextsample.testTimeleaf;

public class TestDtoTimeleaf {
    private Long id;
    private String name;

    public TestDtoTimeleaf() {
    }

    public TestDtoTimeleaf(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestDtoTimeleaf{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
