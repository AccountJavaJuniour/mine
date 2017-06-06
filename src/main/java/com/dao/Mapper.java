/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;
import com.data.TextData;
/**
 *
 * @author Welcome
 */
public interface Mapper {
    
    public TextData selectById(int id);
    public int insert(TextData data);
    public int update(TextData data);
    public boolean isExists(int id);
  
}
