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
public class TextDataDao {
   private Mapper mapper = null;
   public void setMapper(Mapper map)
   {
       this.mapper = map;
   }
   public Mapper getMapper()
   {
       return this.mapper;
   }
   public String GetData(int id)
   {
     if (mapper.isExists(id))
         return mapper.selectById(id).getName();
     return "not found";
   }
   public boolean Update(TextData data)
   {
       if (mapper.isExists(data.getId()))
       {
           mapper.update(data);
           return true;
       }
       else
       {
           mapper.insert(data);
           return false;
       }
      
   }
    
}
