package com.viki3d.proxiad.aci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit tests for {@code TvProgramItem}.
 *
 * @author viki3d
 */
public class TvProgramItemTests {
  
  private static final Logger logger = LoggerFactory.getLogger(TvProgramItemTests.class);
  
  @Test
  @DisplayName("The initial use case scenario")
  void testUseCase1(TestInfo testInfo) {
    logger.trace(String.format("Running test: '%30s' <-", testInfo.getDisplayName()));
    TvProgramItem newsAt10 = new TvProgramItem("News at 10", 10, 0, 10, 30);
    TvProgramItem shortNews = new TvProgramItem("Short news", 17, 30, 17, 40);
    
    TvProgramItem[] items = new TvProgramItem[] { newsAt10, shortNews }; 
  
    assertEquals(TvProgramItem.findLongestItem(items), "News at 10");
  }
  
  @Test
  @DisplayName("CompareTo")
  void testComparaTo(TestInfo testInfo) {
    logger.trace(String.format("Running test: '%30s' <-", testInfo.getDisplayName()));
    TvProgramItem newsAt10 = new TvProgramItem("News at 10", 10, 0, 10, 30);
    TvProgramItem shortNews = new TvProgramItem("Short news", 17, 30, 17, 40);
    
    assertEquals(newsAt10.compareTo(shortNews), 1);
  }
  
  @Test
  @DisplayName("Simple sequence")
  void testUseCase2(TestInfo testInfo) {
    logger.trace(String.format("Running test: '%30s' <-", testInfo.getDisplayName()));
    TvProgramItem tpi1 = new TvProgramItem("item 1", 0, 0, 0, 10); //10 min length
    TvProgramItem tpi2 = new TvProgramItem("item 2", 0, 0, 0, 20); //20 min length
    TvProgramItem tpi3 = new TvProgramItem("item 3", 0, 0, 0, 30); //30 min length
    
    TvProgramItem[] items = new TvProgramItem[] { tpi1, tpi2, tpi3 };
    
    assertEquals(TvProgramItem.findLongestItem(items), "item 3");
  }
  
  // Due TDD demand wider code coverage we should implement multiple unit tests about valid 
  // parameters ranges. Google general guideline for coverage is: 60% acceptable,  
  // 75% as commendable and 90% as exemplary.
  
  @Test
  @DisplayName("Parameters range: beginHours negative")
  void testParametersRangeNegativeBeginHours(TestInfo testInfo) {
    logger.trace(String.format("Running test: '%30s' <-", testInfo.getDisplayName()));
    assertThrows(IllegalArgumentException.class, () -> 
        new TvProgramItem("item 1", -1, 0, 0, 0));
  }
  
  @Test
  @DisplayName("Parameters range: beginHours exceed")
  void testParametersRangeExceedBeginHours(TestInfo testInfo) {
    logger.trace(String.format("Running test: '%30s' <-", testInfo.getDisplayName()));
    assertThrows(IllegalArgumentException.class, () -> 
        new TvProgramItem("item 1", 25, 0, 0, 0));
  }
  
  @Test
  @DisplayName("Parameters range: endHours negative")
  void testParametersRangeNegativeEndHours(TestInfo testInfo) {
    logger.trace(String.format("Running test: '%30s' <-", testInfo.getDisplayName()));
    assertThrows(IllegalArgumentException.class, () -> 
        new TvProgramItem("item 1", 0, 0, -1, 0));
  }
  
  @Test
  @DisplayName("Parameters range: endHours exceed")
  void testParametersRangeExceedEndHours(TestInfo testInfo) {
    logger.trace(String.format("Running test: '%30s' <-", testInfo.getDisplayName()));
    assertThrows(IllegalArgumentException.class, () -> 
        new TvProgramItem("item 1", 0, 0, 25, 0));
  }
  
  @Test
  @DisplayName("Parameters range: beginMinutes negative")
  void testParametersRangeNegativeBeginMinutes(TestInfo testInfo) {
    logger.trace(String.format("Running test: '%30s' <-", testInfo.getDisplayName()));
    assertThrows(IllegalArgumentException.class, () -> 
        new TvProgramItem("item 1", 0, -1, 0, 0));
  }
  
  @Test
  @DisplayName("Parameters range: beginMinutes exceed")
  void testParametersRangeExceedBeginMinutes(TestInfo testInfo) {
    logger.trace(String.format("Running test: '%30s' <-", testInfo.getDisplayName()));
    assertThrows(IllegalArgumentException.class, () -> 
        new TvProgramItem("item 1", 0, 60, 0, 0));
  }
  
  @Test
  @DisplayName("Parameters range: endMinutes negative")
  void testParametersRangeNegativeEndMinutes(TestInfo testInfo) {
    logger.trace(String.format("Running test: '%30s' <-", testInfo.getDisplayName()));
    assertThrows(IllegalArgumentException.class, () -> 
        new TvProgramItem("item 1", 0, 0, 0, -1));
  }
  
  @Test
  @DisplayName("Parameters range: endMinutes exceed")
  void testParametersRangeExceedEndMinutes(TestInfo testInfo) {
    logger.trace(String.format("Running test: '%30s' <-", testInfo.getDisplayName()));
    assertThrows(IllegalArgumentException.class, () -> 
        new TvProgramItem("item 1", 0, 0, 0, 60));
  }
  
  @Test
  @DisplayName("Parameters range: name null")
  void testParameterNameNull(TestInfo testInfo) {
    logger.trace(String.format("Running test: '%30s' <-", testInfo.getDisplayName()));
    assertThrows(IllegalArgumentException.class, () -> 
        new TvProgramItem(null, 0, 0, 0, 0));
  }
  
  @Test
  @DisplayName("Parameters range: name empty")
  void testParameterNameEmpty(TestInfo testInfo) {
    logger.trace(String.format("Running test: '%30s' <-", testInfo.getDisplayName()));
    assertThrows(IllegalArgumentException.class, () -> 
        new TvProgramItem("", 0, 0, 0, 0));
  }

}
