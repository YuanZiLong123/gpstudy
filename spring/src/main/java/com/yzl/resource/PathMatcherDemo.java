package com.yzl.resource;

import com.yzl.resource.utils.ResourceUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author admin
 * @date 2020-08-19 10:28
 */
public class PathMatcherDemo {

    public static void main(String[] args) throws IOException {
        String loaderPath =  System.getProperty("user.dir")+"\\spring\\src\\main\\java\\com\\yzl\\resource\\";
        String locationPattern = loaderPath + "*.java";
        PathMatchingResourcePatternResolver resolver =
                new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());

        resolver.setPathMatcher(new JavaPathMatcher());

        Resource[] resources = resolver.getResources(locationPattern);

        Stream.of(resources).map(ResourceUtils::getContent).forEach(System.out::println);

    }

}

class JavaPathMatcher implements PathMatcher{

    @Override
    public boolean isPattern(String path) {
        return path.endsWith(".java");
    }

    @Override
    public boolean match(String pattern, String path) {
        return path.endsWith(".java");
    }

    @Override
    public boolean matchStart(String pattern, String path) {
        return false;
    }

    @Override
    public String extractPathWithinPattern(String pattern, String path) {
        return null;
    }

    @Override
    public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
        return null;
    }

    @Override
    public Comparator<String> getPatternComparator(String path) {
        return null;
    }

    @Override
    public String combine(String pattern1, String pattern2) {
        return null;
    }
}


