package org.tfc;

import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration
@Transactional
public abstract class DaoTest extends SpringTest {



}