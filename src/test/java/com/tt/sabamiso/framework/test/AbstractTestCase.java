/*-
 * Copyright (c) 2004-2014 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package com.tt.sabamiso.framework.test;

import java.io.FileInputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * integration層、service層の単体テスト基底クラスです.<br>
 * DBUnitを利用してテストデータの登録を行います.<br>
 * 
 * @author usr160056
 * @since 2014/01/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:servlet-test-context.xml")
public abstract class AbstractTestCase extends DatabaseTestCase {

    /** log - ログインスタンス*/
    protected static Log log = LogFactory.getLog(AbstractTestCase.class);

    @Autowired
    private DataSource dataSource;

    private final String testDataDir = "src/test/resources/com/tt/sabamiso/testdata/";

    /** DbUnit専用 */
    private IDatabaseConnection connection = null;

    /** 
     * default Constractor
     */
    public AbstractTestCase() {
        super();
    }

    /** {@inheritDoc} */
    @Override
    @Before
    public void setUp() throws Exception {
        log.info("setUp.");
        super.setUp();
    }

    /** {@inheritDoc} */
    @Override
    @After
    public void tearDown() throws Exception {
        log.info("tearDown.");
        super.tearDown();
        if (!connection.getConnection().isClosed()) {
            log.info("close connection.");
            connection.close();
        }
    }

    /** {@inheritDoc} */
    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        // Connectionの取得
        Connection conn = dataSource.getConnection();
        // IDatabaseConnectionの作成
        connection = new MySqlConnection(conn, "");
        return connection;
    }

    /**
     * テストデータを返します.
     * defaultでは<code>[src/test/resources/com/tt/sabamiso/testdata/]</code>配下の
     * <code>[テストクラス名.xml]</code>を読み込みます.<br>
     * 別名のファイルを読み込む場合は当メソッドをオーバーライドしてください.
     */
    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream(testDataDir + this.getClass().getSimpleName() + ".xml"));
    }
}
