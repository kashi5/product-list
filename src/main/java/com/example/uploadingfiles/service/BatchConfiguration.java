package com.example.uploadingfiles.service;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.example.uploadingfiles.JobCompletionNotificationListener;
import com.example.uploadingfiles.model.Product;




@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @Bean
  public FlatFileItemReader<Product> reader() {
    return new FlatFileItemReaderBuilder<Product>()
      .name("productItemReader")
      .resource(new FileSystemResource("C:\\Users\\Alok\\Desktop\\temp\\gs-uploading-files-master\\complete\\src\\main\\resources\\upload-dir\\text.csv"))
      .delimited()
      .names(new String[]{"id", "productName","brand","model","price"})
      .fieldSetMapper(new BeanWrapperFieldSetMapper<Product>() {{
        setTargetType(Product.class);
      }})
      .build();
  }



  @Bean
  public JdbcBatchItemWriter<Product> writer(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<Product>()
      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
      .sql("INSERT INTO product (id, product_name, brand, model, price) VALUES (:id, :productName, :brand, :model, :price)")
      .dataSource(dataSource)
      .build();
    
  }
  
  @Bean
  public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
    return jobBuilderFactory.get("importUserJob")
      .incrementer(new RunIdIncrementer())
      .listener(listener)
      .flow(step1)
      .end()
      .build();
  }

  @Bean
  public Step step1(JdbcBatchItemWriter<Product> writer) {
    return stepBuilderFactory.get("step1")
      .<Product, Product> chunk(250000)
      .reader(reader())
      .writer(writer)
      .build();
  }

}