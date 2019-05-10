package sharkbound.commonutils.tests

import org.junit.Assert
import org.junit.Test
import sharkbound.commonutils.exceptions.ValueNotSetException
import sharkbound.commonutils.maybeOf
import sharkbound.commonutils.emptyMaybe

internal class TestMaybe {

    @Test
    fun testGetValueOrNull() {
        Assert.assertEquals(null, emptyMaybe<Int>().valueOrNull)
        Assert.assertEquals(1, maybeOf(1).valueOrNull)
    }

    @Test
    fun testGetHasValue() {
        Assert.assertTrue(maybeOf(1).isPresent)
        Assert.assertFalse(emptyMaybe<Int>().isPresent)
    }

    @Test
    fun testGetValue() {
        try {
            emptyMaybe<Int>().value
            assert(false) { "Maybe with no value should raise ValueNotSetException on .value being accessed" }
        } catch (e: ValueNotSetException) {

        }
    }

    @Test
    fun testMatches() {
        Assert.assertTrue("matches should return true when the values are the same", maybeOf(1) matches 1)
        Assert.assertTrue("matches should return true when the predicate returns true", maybeOf(1) matches { true })
    }

    @Test
    fun testNotMatches() {
        Assert.assertTrue("notMatches should return true when the values do not match", maybeOf(1) notMatches 2)
        Assert.assertTrue("notMatches should return true when predate returns false", maybeOf(1) notMatches { false })
    }

    @Test
    fun testIfAbsent() {

    }

    @Test
    fun testIfPresent() {
    }

    @Test
    fun testIfMatches() {
    }

    @Test
    fun testIfMatches1() {
    }

    @Test
    fun testIfNotMatches() {
    }

    @Test
    fun testIfNotMatches1() {
    }

    @Test
    fun testMapIfPresent() {
    }

    @Test
    fun testMapIfAbsent() {
    }

    @Test
    fun testMap() {
    }

    @Test
    fun testFilter() {
    }

    @Test
    fun testMatchesOrDefault() {
    }

    @Test
    fun testMatchesOrDefault1() {
    }

    @Test
    fun testOrDefault() {
    }

    @Test
    fun testOrDefaultLambda() {
    }
}