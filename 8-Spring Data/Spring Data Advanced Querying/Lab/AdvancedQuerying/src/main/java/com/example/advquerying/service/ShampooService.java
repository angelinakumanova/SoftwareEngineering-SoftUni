package com.example.advquerying.service;

public interface ShampooService {

    void getShampoosBySize(String size);

    void getShampoosBySizeOrLabel(String size, Long labelId);
}
