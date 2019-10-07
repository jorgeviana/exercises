package com.example.tellyo.jpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTests {

	@Autowired
	private VideoRepository videoRepository;

	@Autowired
	private DailyStatisticsRepository dailyStatisticsRepository;

	private Video bambi;
	private DailyStatistics bambiDailyStatistics1;
	private DailyStatistics bambiDailyStatistics2;

	@Before
	public void setUp() throws Exception {
		log.info(" ### Cleaning DB");
		videoRepository.deleteAll();
		dailyStatisticsRepository.deleteAll();

		bambi = new Video("Bambi", new Date(), null, false);
		videoRepository.save(bambi);

		bambiDailyStatistics1 = new DailyStatistics(new Date(), 1, 1, bambi);
		dailyStatisticsRepository.save(bambiDailyStatistics1);

		bambiDailyStatistics2 = new DailyStatistics(new Date(), 2, 2, bambi);
		dailyStatisticsRepository.save(bambiDailyStatistics2);

		HashSet<DailyStatistics> dailyStatisticsSet = new HashSet<>();
		dailyStatisticsSet.add(bambiDailyStatistics1);
		dailyStatisticsSet.add(bambiDailyStatistics2);

		bambi.setDailyStatistics(dailyStatisticsSet);
		videoRepository.save(bambi);
	}

	@Test
	public void deleting() {
		log.info(" ###  Asserting before...");
		assertThat(videoRepository.findAll()).hasSize(1);
		assertThat(dailyStatisticsRepository.findAll()).hasSize(2);


		log.info(" ###  Deleting");
		videoRepository.delete(bambi);

		log.info(" ###  Asserting after...");
		assertThat(videoRepository.findAll()).hasSize(0);
		assertThat(dailyStatisticsRepository.findAll()).hasSize(0);
	}

	@Test
	public void loading_videos_lazily() {
		log.info(" ###  Fetching all videos");
		assertThat(videoRepository.findAll()).hasSize(1);
	}

	@Test
	public void loading_daily_statistics_loads_video_eagerly() {
		log.info(" ###  Fetching all stats");
		assertThat(dailyStatisticsRepository.findAll()).hasSize(2);
	}
}
